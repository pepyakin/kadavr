package org.knott.kadavr.metadata;

import java.util.HashMap;
import java.util.Map;

import static org.knott.kadavr.metadata.ConstPool.*;

/**
 *
 * @author Sergey
 */
public class ItemDispatcher {
    
    private Map<Integer, Class<? extends ConstItem>> bindings;

    public ItemDispatcher() {
        bindings = new HashMap<Integer, Class<? extends ConstItem>>();
    }
    
    /**
     * Зарегистрировать тегу соответствующий 
     * считыватель.
     * @param tag
     * @param reader Экземпляр считывателя.
     */
    public void bind(int tag, Class<? extends ConstItem> reader) {
        if (reader == null) {
            throw new NullPointerException();
        }
        
        if (bindings.containsKey(tag)) {
            throw new RuntimeException("already binded tag");
        }
        
        bindings.put(tag, reader);
    }
    
    public void unbind(int tag) {
        Integer key = tag;
        
        if (bindings.containsKey(key)) {
            bindings.remove(key);
        }
    }
    
    /**
     * Запросить считывателя по заданному
     * тегу.
     * @param tag Тег структуры которую нужно возвратить.
     * @return 
     */
    public Class<? extends ConstItem> dispatch(int tag) {
        Class<? extends ConstItem> r = bindings.get(tag);
        if (r == null) {
            // TODO: поменять на другое исключение
            throw new RuntimeException("tag not found");
        }
        
        return r;
    }
    
    public static ItemDispatcher getDefaultDispatcher() {
        ItemDispatcher dispatch = new ItemDispatcher();
        dispatch.defaultBind();
        return dispatch;
    }
    
    private void defaultBind() {
        bind(TAG_CLASS, ClassItem.class);
        bind(TAG_DOUBLE, DoubleItem.class);
        bind(TAG_FIELDREF, FieldrefItem.class);
        bind(TAG_FLOAT, FloatItem.class);
        bind(TAG_INTEGER, IntegerItem.class);
        bind(TAG_INTERFACEMETHODREF, IMethodrefItem.class);
        bind(TAG_LONG, LongItem.class);
        bind(TAG_METHODREF, MethodrefItem.class);
        bind(TAG_NAMEANDTYPE, NameTypeItem.class);
        bind(TAG_STRING, StringItem.class);
        bind(TAG_UTF8, Utf8Item.class);
    }
}
