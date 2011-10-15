package org.knott.kadavr.metadata;

import org.knott.kadavr.metadata.attr.Attribute;
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
        for (int i = 0; i < attributes.length; i++) {
            Attribute attribute = attributes[i];
            
            if (attribute.getName().equals("Code")) {
                return (Code)attribute;
            }
        }
        
        return null;
    }
}
