package org.knott.kadavr.metadata;

import java.io.IOException;

/**
 *
 * @author Sergey
 */
public class IntegerItem extends ConstItem {

    public static final int TAG = ConstPool.TAG_INTEGER;
    
    int value;
    
    @Override
    void link(ConstPool pool) {
    }

    @Override
    public int getTag() {
        return TAG;
    }
    
    static class IntegerReader extends Reader<IntegerItem> {

        @Override
        protected IntegerItem readItem(ClassFileReader dis) throws IOException {
            IntegerItem item = new IntegerItem();
            
            // CONSTANT_Integer_info {
            //	u1 tag;
    	    //  u4 bytes;
            // }
            
            item.value = dis.readInt();
            
            return item;
        }

        @Override
        int getTag() {
            return TAG;
        }
    }
}
