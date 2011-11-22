package org.knott.kadavr.metadata;

import java.io.IOException;

/**
 * Класс представляет собой описание
 * элемента "тип и именя".
 * 
 * @author Sergey
 */
public class NameTypeItem extends ConstItem {

    /**
     * Эта константа описывает тэг объектов данного типа.
     * Эта константа имеет значение {@value}.
     */
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

    @Override
    protected void read(ClassFileReader dis) throws IOException {
        nameIndex = dis.readU2();
        descIndex = dis.readU2();
    }
}
