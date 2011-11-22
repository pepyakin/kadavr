package org.knott.kadavr.metadata;

import java.io.IOException;

/**
 * Класс описывающий элемент типа int.
 * @author Sergey
 */
public class IntegerItem extends ConstValueItem {

    /**
     * Эта константа описывает тэг объектов данного типа.
     * Эта константа имеет значение {@value}.
     */
    public static final int TAG = ConstPool.TAG_INTEGER;

    int value;

    /**
     * {@inheritDoc}
     */
    @Override
    void link(ConstPool pool) {
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
        value = dis.readInt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getValueString() {
        return Integer.toString(value);
    }
}
