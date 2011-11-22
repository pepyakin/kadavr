package org.knott.kadavr.metadata;

import java.io.IOException;

/**
 * Представляет базовый класс для элементов
 * константного пула представляющих члены типа.
 *
 * @author Sergey
 */
public abstract class MemberItem extends ConstItem {

    int ownerClassIndex;
    int nameTypeIndex;
    private ClassItem owner;
    private NameTypeItem nameType;

    private int tag;

    /**
     * Инициировать данный объект.
     */
    protected MemberItem(int tag) {
        this.tag = tag;
    }

    /**
     * Возвратить имя и дескриптор данного члена.
     * @return
     */
    public NameTypeItem getNameType() {
        return nameType;
    }

    /**
     * Возвратить тип декларирующий данный член.
     * @return
     */
    public ClassItem getOwner() {
        return owner;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void link(ConstPool pool) {
        owner = pool.getClass(ownerClassIndex);
        nameType = pool.getNameAndType(nameTypeIndex);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getTag() {
        return tag;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void read(ClassFileReader dis) throws IOException {
        ownerClassIndex = dis.readU2();
        nameTypeIndex = dis.readU2();
    }

    /**
     * Абстрактный метод, который потомки должны реализовать
     * для получения строки операнда.
     *
     * @return
     */
    public abstract String getOperandString();
}
