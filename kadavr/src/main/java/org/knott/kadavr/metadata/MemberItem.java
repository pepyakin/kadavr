package org.knott.kadavr.metadata;

import java.io.IOException;

/**
 *
 * @author Sergey
 */
public abstract class MemberItem extends ConstItem {

    int ownerClassIndex;
    int nameTypeIndex;
    private ClassItem owner;
    private NameTypeItem nameType;
    
    private int tag;
    
    protected MemberItem(int tag) {
        this.tag = tag;
    }

    public NameTypeItem getNameType() {
        return nameType;
    }

    public ClassItem getOwner() {
        return owner;
    }

    @Override
    void link(ConstPool pool) {
        owner = pool.getClass(ownerClassIndex);
        nameType = pool.getNameAndType(nameTypeIndex);
    }

    @Override
    public int getTag() {
        return tag;
    }

    @Override
    protected void read(ClassFileReader dis) throws IOException {
        ownerClassIndex = dis.readU2();
        nameTypeIndex = dis.readU2();
    }
    
    public abstract String getOperandString();
}
