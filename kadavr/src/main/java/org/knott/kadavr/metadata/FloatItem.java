package org.knott.kadavr.metadata;

import java.io.IOException;

/**
 *
 * @author Sergey
 */
public class FloatItem extends ConstItem {
    
    public static final int TAG = ConstPool.TAG_FLOAT;

    float value;
    
    @Override
    void link(ConstPool pool) {
    }

    @Override
    public int getTag() {
        return TAG;
    }
    
    static class FloatReader extends Reader<FloatItem> {

        @Override
        protected FloatItem readItem(ClassFileReader dis) throws IOException {
            FloatItem item = new FloatItem();
            
            // CONSTANT_Float_info {
            //	u1 tag;
    	    //  u4 bytes;
            // }
            item.value = dis.readFloat();
            
            return item;
        }

        @Override
        int getTag() {
            return TAG;
        }
        
    }
}
