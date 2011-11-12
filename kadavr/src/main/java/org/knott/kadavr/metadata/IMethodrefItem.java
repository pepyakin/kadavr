package org.knott.kadavr.metadata;

/**
 *
 * @author Sergey
 */
public class IMethodrefItem extends MemberItem {
    
    public static final int TAG = ConstPool.TAG_INTERFACEMETHODREF;

    public IMethodrefItem() {
        super(TAG);
    }
    
    @Override
    public String getOperandString() {
        StringBuilder sb = new StringBuilder();
        ClassItem owner = getOwner();
        NameTypeItem nameType = getNameType();
        
        String ownerType = owner.getTypeName();
        String name = nameType.getName().get();
        String type = nameType.getDescriptor().get();
        
        sb.append(ownerType);
        sb.append('/');
        sb.append(name);
        sb.append(type);
        
        return sb.toString();
    }
}
