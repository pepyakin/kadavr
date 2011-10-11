package org.knott.kadavr.metadata;

import java.io.IOException;

/**
 *
 * @author Sergey
 */
public class StringItem extends ConstItem {

    public static final int TAG = ConstPool.TAG_STRING;
    
    int stringIndex;
    private Utf8Item utf8;

    /**
     * Возратить экземпляр элемента константного пула,
     * в котором хранится строка, представляемая данным
     * элементом.
     * 
     * @return Экземпляр класса {@link Utf8Item} содержащий
     * строку данного элемента.
     */
    public Utf8Item getUtf8() {
        if (utf8 == null) {
            throw new NotLinkedException();
        }
        
        return utf8;
    }
    
    @Override
    void link(ConstPool pool) {
        utf8 = pool.getUtf(stringIndex); 
    }

    @Override
    public int getTag() {
        return TAG;
    }
    
    class StringReader extends Reader<StringItem> {

        @Override
        protected StringItem readItem(ClassFileReader dis) 
                throws IOException {
            StringItem item = new StringItem();
            
            // CONSTANT_String_info {
    	    //   u1 tag;
    	    //   u2 string_index;
            // }
            
            item.stringIndex = dis.readU2();
            
            return item;
        }

        @Override
        int getTag() {
            return TAG;
        }
    }
}
