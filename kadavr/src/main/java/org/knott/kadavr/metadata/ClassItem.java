package org.knott.kadavr.metadata;

import java.io.IOException;

/**
 * Представляет собой элемент в константном пуле
 * описывающий тип.
 *
 * @author Sergey
 */
public class ClassItem extends ConstValueItem {

    /**
     * Эта константа описывает тэг объектов данного типа.
     * Эта константа имеет значение {@value}.
     */
    public static final int TAG = ConstPool.TAG_CLASS;

    int nameIndex;
    private Utf8Item name;

    /**
     * Возвратить имя данного типа.
     * @return
     */
    public Utf8Item getName() {
        if (name == null) {
            throw new NotLinkedException();
        }

        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void link(ConstPool pool) {
        name = pool.getUtf(nameIndex);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getTag() {
        return TAG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void read(ClassFileReader dis) throws IOException {
        nameIndex = dis.readU2();
    }

    /**
     * Возвращает имя типа.
     * @return
     */
    public String getTypeName() {
        return getName().get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getValueString() {
        return getTypeName();
    }
}
