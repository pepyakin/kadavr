package org.knott.kadavr.metadata;

import java.io.IOException;

/**
 *
 * @author Sergey
 */
public class StringItem extends ConstValueItem {

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

    @Override
    protected void read(ClassFileReader dis) throws IOException {
        stringIndex = dis.readU2();
    }

    @Override
    public String getValueString() {
        String value = getUtf8().get();
        StringBuilder sb = new StringBuilder(value.length() + 2);
        sb.append('"');
        sb.append(value);
        sb.append('"');
        return sb.toString();
    }
}
