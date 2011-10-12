package org.knott.kadavr.metadata;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.knott.kadavr.metadata.ConstItem.Reader;
import org.knott.kadavr.metadata.*;
import static org.knott.kadavr.metadata.ConstPool.*;

/**
 *
 * @author Sergey
 */
public class ItemDispatcher {
    
    private Map<Integer, Reader<? extends ConstItem>> readers;

    public ItemDispatcher() {
        readers = new HashMap<
                    Integer, 
                    Reader<? extends ConstItem>>();
    }
    
    /**
     * Зарегистрировать тегу соответствующий 
     * считыватель.
     * @param tag
     * @param reader Экземпляр считывателя.
     */
    public void bind(int tag, Reader<? extends ConstItem> reader) {
        if (reader == null) {
            throw new NullPointerException();
        }
        
        readers.put(tag, reader);
    }
    
    public void unbind(int tag) {
        Integer key = tag;
        
        if (readers.containsKey(key)) {
            readers.remove(key);
        }
    }
    
    /**
     * Запросить считывателя по заданному
     * тегу.
     * @param tag Тег структуры которую нужно возвратить.
     * @return 
     */
    public Reader<? extends ConstItem> dispatch(int tag) {
        Reader<? extends ConstItem> r = readers.get(tag);
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
        bind(TAG_CLASS, ClassItem.ClassReader.class);
        bind(TAG_DOUBLE, DoubleItem.DoubleReader.class);
        bind(TAG_FIELDREF, FieldrefItem.FieldrefReader.class);
        bind(TAG_FLOAT, FloatItem.FloatReader.class);
        bind(TAG_INTEGER, IntegerItem.IntegerReader.class);
        bind(TAG_INTERFACEMETHODREF, IMethodrefItem.IMethodrefReader.class);
        bind(TAG_LONG, LongItem.LongReader.class);
        bind(TAG_METHODREF, MethodrefItem.MethodrefReader.class);
        bind(TAG_NAMEANDTYPE, NameTypeItem.NameTypeReader.class);
        bind(TAG_STRING, StringItem.StringReader.class);
        bind(TAG_UTF8, Utf8Item.Utf8Reader.class);
    }
    
    private void bind(
            int tag, Class<? extends Reader> creator) {
        
        Reader reader;
        try {
            reader = creator.newInstance();
        } catch (InstantiationException ex) {
            throw new RuntimeException(ex);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
        
        bind(tag, reader);
    }
}
