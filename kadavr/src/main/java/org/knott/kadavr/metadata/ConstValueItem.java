package org.knott.kadavr.metadata;

/**
 * Элемент константного пула, который может использоваться
 * в качестве константы.
 *
 * @author Sergey
 */
public abstract class ConstValueItem extends ConstItem {

    /**
     * Возвратить строковое удобочитаемое значение
     * данного элемента.
     * @return Удобочитаемое представление элемента.
     */
    public abstract String getValueString();
}
