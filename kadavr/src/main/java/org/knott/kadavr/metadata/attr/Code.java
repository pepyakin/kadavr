package org.knott.kadavr.metadata.attr;

import java.io.IOException;
import org.knott.kadavr.metadata.ClassFileReader;
import org.knott.kadavr.metadata.ConstPool;

/**
 * Аттрибут, который по спецификации Java хранит
 * в себе Java байткод.
 * @author Sergey
 */
public class Code extends Attribute {

    private int maxLocals, maxStack;
    private byte[] code;
    private ExceptionEntry[] exceptions;
    private Attribute[] attributes;

    /**
     * Возвратить массив с байткодом
     * реализующим метод, аттрибутом которого
     * является данный экземпляр.
     * @return 
     */
    public byte[] getCode() {
        return code;
    }

    /**
     * Возратить количество локальных
     * слотов определённых в данном 
     * методе.
     * @return 
     */
    public int getMaxLocals() {
        return maxLocals;
    }

    /**
     * Возратить количество слотов
     * стека необходимых для выполнения данного
     * метода.
     * @return 
     */
    public int getMaxStack() {
        return maxStack;
    }
    
    /**
     * Возратить количество записей
     * в таблице исключений данного 
     * аттрибута.
     */
    public int getExceptionCount() {
        return exceptions.length;
    }
    
    /**
     * Возратить запись из таблицы исключений.
     */
    public ExceptionEntry getException(int i) {
        return exceptions[i];
    }
    
    public int getAttributeCount() {
        return attributes.length;
    }
    
    public Attribute get(int i) {
        return attributes[i];
    }
    
    @Override
    public void read(ConstPool pool, ClassFileReader dis) 
            throws IOException {
        //Code_attribute {
        //    u2 attribute_name_index;
        //    u4 attribute_length;
        //    u2 max_stack;
        //    u2 max_locals;
        //    u4 code_length;
        //    u1 code[code_length];
        //    u2 exception_table_length;
        //    {    	u2 start_pc;
        //            u2 end_pc;
        //            u2  handler_pc;
        //            u2  catch_type;
        //    }	exception_table[exception_table_length];
        //    u2 attributes_count;
        //    attribute_info attributes[attributes_count];
        //}
        
        maxStack = dis.readU2();
        maxLocals = dis.readU2();
        
        // Возможный баг.
        long codeLength = dis.readU4();
        code = new byte[(int)codeLength];
        dis.read(code);
        
        // Прочитать все записи в таблице исключенй.
        int exceptionsLength = dis.readU2();
        exceptions = new ExceptionEntry[exceptionsLength];
        for (int i = 0; i < exceptionsLength; i++) {
            ExceptionEntry entry = new ExceptionEntry();
            entry.read(dis);
            exceptions[i] = entry;
        }
        
        AttributeReader reader = new AttributeReader(pool);
        attributes = reader.read(dis);
    }

    @Override
    public String getName() {
        return "Code";
    }
    
    /**
     * Класс представляющий собой запись 
     * в таблице исключений в аттрибуте <i>Code</i>.
     */
    public static class ExceptionEntry {
        private int startPC, endPC;
        private int handlerPC;
        private int catchType;

        ExceptionEntry(int startPC, int endPC, int handlerPC, int catchType) {
            this.startPC = startPC;
            this.endPC = endPC;
            this.handlerPC = handlerPC;
            this.catchType = catchType;
        }

        public ExceptionEntry() {
        }
        
        /**
         * Считать данные из потока.
         * @param dis
         * @throws IOException 
         */
        public void read(ClassFileReader dis) 
                throws IOException {
            //u2 exception_table_length;
            //{
            //  u2 start_pc;
            //  u2 end_pc;
            //  u2 handler_pc;
            //  u2 catch_type;
            //}
            startPC = dis.readU2();
            endPC = dis.readU2();
            handlerPC = dis.readU2();
            catchType = dis.readU2();
        }

        public int getCatchType() {
            return catchType;
        }

        public int getEndPC() {
            return endPC;
        }

        public int getHandlerPC() {
            return handlerPC;
        }

        public int getStartPC() {
            return startPC;
        }
    }
}
