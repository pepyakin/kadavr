package org.knott.kadavr.metadata;

import java.io.IOException;

/**
 *
 * @author Sergey
 */
public class ClassItem extends ConstItem {
    
    public static final int TAG = ConstPool.TAG_CLASS;
    
    int nameIndex;
    private Utf8Item name;

    public Utf8Item getName() {
        if (name == null) {
            throw new NotLinkedException();
        }
        
        return name;
    }

    @Override
    void link(ConstPool pool) {
        name = pool.getUtf(nameIndex);
    }

    @Override
    public int getTag() {
        return TAG;
    }

    @Override
    protected void read(ClassFileReader dis) throws IOException {
        nameIndex = dis.readU2();
    }
    
    public String getTypeName() {
        return getName().get();
    }
}
