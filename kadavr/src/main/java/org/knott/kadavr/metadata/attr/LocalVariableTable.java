package org.knott.kadavr.metadata.attr;

import java.io.IOException;
import org.knott.kadavr.metadata.ClassFileReader;
import org.knott.kadavr.metadata.ConstPool;
import org.knott.kadavr.metadata.Utf8Item;

/**
 *
 * @author Sergey
 */
public class LocalVariableTable extends Attribute {

    private Local[] locals;
    
    @Override
    public void read(ConstPool pool, ClassFileReader dis) 
            throws IOException {
        //LocalVariableTable_attribute {
        //    u2 attribute_name_index;
        //    u4 attribute_length;
        //    u2 local_variable_table_length;
        //    {  u2 start_pc;
        //        u2 length;
        //        u2 name_index;
        //        u2 descriptor_index;
        //        u2 index;
        //    } local_variable_table[local_variable_table_length];
        //}	
        int len = dis.readU2();
        locals = new Local[len];
        
        for (int i = 0; i < len; i++) {
            Local local = new Local();
            local.read(pool, dis);
            locals[i] = local;
        }
    }

    @Override
    public String getName() {
        return "LocalVariableTable";
    }
    
    public static class Local {
        
        private int startPC;
        private int length;
        private Utf8Item name;
        private Utf8Item descriptor;
        private int index;

        public Utf8Item getDescriptor() {
            return descriptor;
        }

        public int getIndex() {
            return index;
        }

        public int getLength() {
            return length;
        }

        public Utf8Item getName() {
            return name;
        }

        public int getStartPC() {
            return startPC;
        }
        
        public void read(ConstPool pool, ClassFileReader dis) 
            throws IOException {
            startPC = dis.readU2();
            length = dis.readU2();
            
            name = pool.getUtf(dis.readU2());
            descriptor = pool.getUtf(dis.readU2());
            
            index = dis.readU2();
        }
    }
}
