package org.knott.kadavr.metadata;

import java.io.IOException;

/**
 * Класс описывающий элемент типа double.
 * @author Sergey
 */
public class DoubleItem extends ConstValueItem {

    /**
     * Эта константа описывает тэг объектов данного типа.
     * Эта константа имеет значение {@value}.
     */
    public static final int TAG = ConstPool.TAG_DOUBLE;

    double value;

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
        value = dis.readDouble();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getValueString() {
        return Double.toString(value);
    }
}
