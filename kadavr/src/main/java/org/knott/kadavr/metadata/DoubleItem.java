package org.knott.kadavr.metadata;

import java.io.IOException;

/**
 *
 * @author Sergey
 */
public class DoubleItem extends ConstItem {
    
    public static final int TAG = ConstPool.TAG_DOUBLE;
    
    double value;

    @Override
    void link(ConstPool pool) {
    }

    @Override
    public int getTag() {
        return TAG;
    }
    
    static class DoubleReader extends Reader<DoubleItem> {

        @Override
        protected DoubleItem readItem(ClassFileReader dis) throws IOException {
            DoubleItem item = new DoubleItem();
            
            // CONSTANT_Double_info {
    	    //  u1 tag;
    	    //  u4 high_bytes;
    	    //  u4 low_bytes;
            // }
            item.value = dis.readDouble();
            
            return item;            
        }

        @Override
        int getTag() {
            return TAG;
        }
    }
}
