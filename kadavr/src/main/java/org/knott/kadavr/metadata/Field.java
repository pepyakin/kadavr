package org.knott.kadavr.metadata;

import org.knott.kadavr.metadata.attr.Attribute;
import org.knott.kadavr.metadata.attr.ConstantValue;

/**
 * Данный класс представляет описание поля.
 * @author Sergey
 */
public class Field extends Member {

    /**
     * Возвращает константное значение присвоенное данному типу
     * или null.
     * @return
     */
    public ConstantValue getConstantValue() {
        for (Attribute attr : attributes) {
            if (attr.getName().equals(ConstantValue.NAME)) {
                return (ConstantValue)attr;
            }
        }

        return null;
    }
}
