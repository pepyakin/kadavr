package org.knott.kadavr.metadata;

import org.knott.kadavr.metadata.attr.Attribute;
import org.knott.kadavr.metadata.attr.ConstantValue;

/**
 *
 * @author Sergey
 */
public class Field extends Member {
    
    public ConstantValue getConstantValue() {
        for (Attribute attr : attributes) {
            if (attr.getName().equals(ConstantValue.NAME)) {
                return (ConstantValue)attr;
            }
        }
        
        return null;
    }
}
