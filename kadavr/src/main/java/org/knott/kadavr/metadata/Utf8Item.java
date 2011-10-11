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
    
    /**
     * Считыватель для {@link Utf8Item}.
     */
    class Utf8Reader extends ConstItem.Reader<Utf8Item> {

        @Override
        protected Utf8Item readItem(ClassFileReader dis) 
                throws IOException {
            Utf8Item utf8 = new Utf8Item();
            
            // CONSTANT_Utf8_info {
            //     u1 tag;
            //     u2 length;
            //     u1 bytes[length];
            // }
            
            // Прочитать целое означающее длину строки.
            int len = dis.readU2();
            byte[] bytes = new byte[len];
            
            dis.read(bytes);
            
            // И создать соответствующую строку.
            utf8.item = new String(bytes);
            
            return utf8;
        }

        @Override
        int getTag() {
            return TAG;
        }
    }
}
