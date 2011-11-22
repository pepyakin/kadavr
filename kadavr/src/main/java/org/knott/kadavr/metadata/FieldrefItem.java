package org.knott.kadavr.metadata;

/**
 * Класс представляет собой описание
 * метода декларированного в типе.
 * @author Sergey
 */
public class FieldrefItem extends MemberItem {

    /**
     * Эта константа описывает тэг объектов данного типа.
     * Эта константа имеет значение {@value}.
     */
    public static final int TAG = ConstPool.TAG_FIELDREF;

    /**
     * Создать экземпляр данного типа.
     */
    public FieldrefItem() {
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
        sb.append(' ');
        sb.append(type);

        return sb.toString();
    }
}
