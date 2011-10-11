package org.knott.kadavr.metadata;

import java.util.List;

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
    
    /**
     * Вернуть элемент константного пула с 
     * заданным индексом.
     * @param index Индекс элемента в пуле констант.
     * @return Экземпляр элемента.
     */
    public Utf8Item getUtf(int index) {
        return (Utf8Item)get(index);
    }
    
    public NameTypeItem getNameAndType(int index) {
        return (NameTypeItem)get(index);
    }
    
    public ClassItem getClass(int index) {
        return (ClassItem)get(index);
    }
    
    public ConstItem get(int index) {
        // TODO: проверить индекс.
        
        return constPool.get(index + 1);
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
     * 
     */
    public void link() {
        // Интересность в том, что для процесса
        // связывания нужно гарантировать, что все элементы
        // уже считанны.
        
        for (int i = 0; i < size(); i++) {
            ConstItem item = get(i);
            item.link(this);
        }
    }
}
