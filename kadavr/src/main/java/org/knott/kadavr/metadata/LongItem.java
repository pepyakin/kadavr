package org.knott.kadavr.metadata;

import java.io.IOException;

/**
 * Класс описывающий элемент типа long.
 * @author Sergey
 */
public class LongItem extends ConstValueItem {

    /**
     * Эта константа описывает тэг объектов данного типа.
     * Эта константа имеет значение {@value}.
     */
    public static final int TAG = ConstPool.TAG_LONG;

    long value;

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
        value = dis.readLong();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getValueString() {
        return Long.toString(value);
    }
}
