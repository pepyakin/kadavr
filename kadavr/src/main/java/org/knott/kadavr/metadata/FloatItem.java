package org.knott.kadavr.metadata;

import java.io.IOException;

/**
 *
 * @author Sergey
 */
public class FloatItem extends ConstValueItem {
    
    public static final int TAG = ConstPool.TAG_FLOAT;

    float value;
    
    @Override
    void link(ConstPool pool) {
    }

    @Override
    public int getTag() {
        return TAG;
    }

    @Override
    protected void read(ClassFileReader dis) throws IOException {
        value = dis.readFloat();
    }
}
