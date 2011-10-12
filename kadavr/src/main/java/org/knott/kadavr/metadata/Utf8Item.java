package org.knott.kadavr.metadata;

import java.io.IOException;

/**
 * Класс, который содержит в себе представление
 * некоторой строчки.
 * @author Sergey
 */
public class Utf8Item extends ConstItem {
    
    public static final int TAG = ConstPool.TAG_UTF8;

    String item;

    @Override
    void link(ConstPool pool) {
        // Примитивный элемент. Делать нечего.
    }

    @Override
    public int getTag() {
        return TAG;
    }
    
    /**
     * Возвратить строку, которую представляет 
     * данный элемент пула.
     * @return 
     */
    public String get() {
        return item;
    }

    @Override
    protected void read(ClassFileReader dis) throws IOException {
        int len = dis.readU2();
        byte[] bytes = new byte[len];
            
        dis.read(bytes);
            
        // И создать соответствующую строку.
        item = new String(bytes);
    }
}
