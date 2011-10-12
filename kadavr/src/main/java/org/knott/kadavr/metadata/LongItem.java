package org.knott.kadavr.metadata;

import java.io.IOException;

/**
 *
 * @author Sergey
 */
public class LongItem extends ConstItem {

    public static final int TAG = ConstPool.TAG_LONG;
    
    long value;
    
    @Override
    void link(ConstPool pool) {
    }

    @Override
    public int getTag() {
        return TAG;
    }
    
    static class LongReader extends Reader<LongItem> {

        @Override
        protected LongItem readItem(ClassFileReader dis) throws IOException {
            LongItem item = new LongItem();
            
            // CONSTANT_Long_info {
    	    //  u1 tag;
    	    //  u4 high_bytes;
    	    //  u4 low_bytes;
            // }
            item.value = dis.readLong();
            
            return item;
        }

        @Override
        int getTag() {
            return TAG;
        }
    }
}
