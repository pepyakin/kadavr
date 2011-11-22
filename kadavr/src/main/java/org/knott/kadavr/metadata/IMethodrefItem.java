package org.knott.kadavr.metadata;

/**
 * Класс представляет собой описание
 * метода декларированного в интерфейсе.
 * @author Sergey
 */
public class IMethodrefItem extends MemberItem {

    /**
     * Эта константа описывает тэг объектов данного типа.
     * Эта константа имеет значение {@value}.
     */
    public static final int TAG = ConstPool.TAG_INTERFACEMETHODREF;

    /**
     * Создать экземпляр данного типа.
     */
    public IMethodrefItem() {
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
