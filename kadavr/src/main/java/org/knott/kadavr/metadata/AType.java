/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.knott.kadavr.metadata;

/**
 * Перечисление декларирует простые типы для
 * использования с инструкцией newarray.
 *
 * @author knott
 */
public enum AType {

    BOOLEAN(4, "boolean"),
    CHAR(5, "char"),
    FLOAT(6, "float"),
    DOUBLE(7, "double"),
    BYTE(8, "byte"),
    SHORT(9, "short"),
    INT(10, "int"),
    LONG(11, "long");

    private final int acode;
    private final String mnemonic;

    /**
     * Возвращает удобочитаемое представление типа.
     * @return
     */
    public String getMnemonic() {
        return mnemonic;
    }

    private AType(int acode, String mnemonic) {
        this.acode = acode;
        this.mnemonic = mnemonic;
    }

    /**
     * Возвратить тип по его коду.
     * @param acode Код простого типа.
     * @return Возвращает найденный тип или null,
     * если не удалось найти тип.
     */
    public static AType byACode(int acode) {
        for (AType atype : values()) {
            if (atype.acode == acode) {
                return atype;
            }
        }

        return null;
    }
}
