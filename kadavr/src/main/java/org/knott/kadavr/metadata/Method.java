package org.knott.kadavr.metadata;

import org.knott.kadavr.AccessFlag;
import org.knott.kadavr.metadata.attr.Code;

/**
 *
 * @author Sergey
 */
public class Method extends Member {

    /**
     * Возвратить аттрибут кода.
     */
    public Code getCode() {
        return attributes.get(Code.NAME);
    }

    /**
     * Возвращает, имеет ли данный метод код или нет?
     * @return
     */
    public boolean haveBody() {
        return !(isAbstract() || isNative());
    }

    /**
     * Возвращает, абстрактный ли данный метод или нет?
     * @return
     */
    public boolean isAbstract() {
        return AccessFlag.ABSTRACT.isSet(accessFlags);
    }

    /**
     * Возвращает, нативный ли данный метод или нет?
     * @return
     */
    public boolean isNative() {
        return AccessFlag.NATIVE.isSet(accessFlags);
    }
}
