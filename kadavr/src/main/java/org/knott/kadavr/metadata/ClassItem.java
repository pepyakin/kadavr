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
    
    class ClassReader extends Reader<ClassItem> {

        @Override
        protected ClassItem readItem(ClassFileReader dis) 
                throws IOException {
            ClassItem item = new ClassItem();
            
            // CONSTANT_Class_info {
            //   u1 tag;
    	    //   u2 name_index;
            // }
            
            item.nameIndex = dis.readU2();
            
            return item;
        }

        @Override
        int getTag() {
            return TAG;
        }
    }
}
