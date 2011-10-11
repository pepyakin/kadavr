package org.knott.kadavr.metadata;

import java.io.IOException;

/**
 *
 * @author Sergey
 */
public class NameTypeItem extends ConstItem {
    
    public static final int TAG = ConstPool.TAG_NAMEANDTYPE;
    
    int nameIndex;
    int descIndex;
    
    private Utf8Item name;
    private Utf8Item descriptor;

    @Override
    void link(ConstPool pool) {
        name = pool.getUtf(nameIndex);
        descriptor = pool.getUtf(descIndex);
    }

    @Override
    public int getTag() {
        return TAG;
    }

    public Utf8Item getDescriptor() {
        if (descriptor == null) {
            throw new NotLinkedException();
        }
        
        return descriptor;
    }

    public Utf8Item getName() {
        if (name == null) {
            throw new NotLinkedException();
        }
        
        return name;
    }
    
    class NameTypeReader extends Reader<NameTypeItem> {

        @Override
        protected NameTypeItem readItem(ClassFileReader dis) 
                throws IOException {
            // CONSTANT_NameAndType_info {
            //   u1 tag;
            //   u2 name_index;
            //   u2 descriptor_index;
            // }
            
            NameTypeItem item = new NameTypeItem();
            
            item.nameIndex = dis.readU2();
            item.descIndex = dis.readU2();
            
            return item;
        }

        @Override
        int getTag() {
            return TAG;
        }
    }
}
