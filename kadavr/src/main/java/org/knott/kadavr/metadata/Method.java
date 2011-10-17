package org.knott.kadavr.metadata;

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
}
