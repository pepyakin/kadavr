package org.knott.kadavr.metadata;

/**
 * Класс представляет собой описание
 * метода декларированного в классе.
 * @author Sergey
 */
public class MethodrefItem extends MemberItem {

    /**
     * Эта константа описывает тэг объектов данного типа.
     * Эта константа имеет значение {@value}.
     */
    public static final int TAG = ConstPool.TAG_METHODREF;

    public MethodrefItem() {
        super(TAG);
    }

    /**
     * {@inheritDoc}
     */
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
