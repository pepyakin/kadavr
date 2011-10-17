package org.knott.kadavr.metadata.attr;

import java.io.IOException;
import org.knott.kadavr.metadata.ClassFileReader;
import org.knott.kadavr.metadata.ConstPool;
import org.knott.kadavr.metadata.ConstValueItem;

/**
 *
 * @author Sergey
 */
public class ConstantValue extends Attribute {
    public static final String NAME = "ConstantValue";

    private ConstValueItem item;

    public ConstValueItem getItem() {
        return item;
    }
    
    @Override
    public void read(ConstPool pool, ClassFileReader dis) 
            throws IOException {
        int idx = dis.readU2();
        item = pool.get(idx);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
