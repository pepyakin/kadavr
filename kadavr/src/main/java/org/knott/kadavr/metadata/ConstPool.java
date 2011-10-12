package org.knott.kadavr.metadata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergey
 */
public class ConstPool {
    
    public static final int TAG_CLASS = 7;
    
    public static final int TAG_FIELDREF = 9;
    
    public static final int TAG_METHODREF = 10;
    
    public static final int TAG_INTERFACEMETHODREF = 11;
    
    public static final int TAG_STRING = 8;
    
    public static final int TAG_INTEGER = 3;
    
    public static final int TAG_FLOAT = 4;
    
    public static final int TAG_LONG = 5;
    
    public static final int TAG_DOUBLE = 6;
    
    public static final int TAG_NAMEANDTYPE = 12;
    
    public static final int TAG_UTF8 = 1;
    
    private List<ConstItem> constPool;
    
    public ConstPool() {
        // Неизвестное число элементов. Лучший вариант
        // использовать связанный список.
        constPool = new LinkedList<ConstItem>();
    }
    
    public ConstPool(int countHint) {
        // Количество элементов известно, используем
        // массивный список.
        constPool = new ArrayList<ConstItem>(countHint);
    }
    
    /**
     * Вернуть элемент константного пула с 
     * заданным индексом.
     * @param index Индекс элемента в пуле констант.
     * @return Экземпляр элемента.
     */
    public Utf8Item getUtf(int index) {
        return get(index);
    }
    
    public NameTypeItem getNameAndType(int index) {
        return get(index);
    }
    
    public ClassItem getClass(int index) {
        return get(index);
    }
    
    public <T extends ConstItem> T get(int index) {
        // TODO: проверить индекс.
        
        return (T)constPool.get(index + 1);
    }

    /**
     * Возратить размер константного пола.
     * @return Возратить количество элементов
     * находящихся в константном пуле.
     */
    public int size() {
        return constPool.size();
    }
    
    /**
     * Инициировать процесс связывания. Процесс связывания
     * происходит после завершения считывания.
     */
    public void link() {
        for (ConstItem constItem : constPool) {
            constItem.link(this);
        }
    }
    
    public static ConstPool read(ItemDispatcher dispatcher, ClassFileReader dis) 
            throws IOException {
        ConstPool pool;
        
        // ClassFile {
        //   .. 
        //   u2 constant_pool_count;
    	//   cp_info constant_pool[constant_pool_count-1];
        //   ..
        // }
        
        int len = dis.readU2();
        pool = new ConstPool(len);
        
        for (int i = 0; i < len; i++) {
            // Заголовок каждой записи - тег.
            // Считываем его и получаем соответсвующий ридер.
            int tag = dis.readU1();
            Class<? extends ConstItem> proto = 
                    dispatcher.dispatch(tag);
            
            ConstItem item;
            try {
                item = proto.newInstance();
                item.read(dis);
            } catch (InstantiationException ex) {
                throw new RuntimeException(ex);
            } catch (IllegalAccessException ex) {
                throw new RuntimeException(ex);
            }
            
            pool.constPool.add(item);
        }
        
        return pool;
    }
}
