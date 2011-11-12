/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.knott.kadavr;

import java.io.IOException;
import org.knott.kadavr.metadata.Field;
import org.knott.kadavr.metadata.attr.ConstantValue;

/**
 *
 * @author knott
 */
public class FieldDisasm {
    
    private Field field;
    private FieldFormatter formatter;

    public FieldDisasm(FieldFormatter formatter, Field field) {
        this.field = field;
        this.formatter = formatter;
    }
    
    public FieldDisasm(IdentTextWriter writer, Field field) {
        this(new FieldFormatter(writer), field);
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public FieldFormatter getFormatter() {
        return formatter;
    }

    public void setFormatter(FieldFormatter formatter) {
        this.formatter = formatter;
    }
    
    public void parse() throws IOException {
        if (field == null) {
            throw new NullPointerException();
        }
        
        if (formatter == null) {
            throw new NullPointerException();
        }
        
        int accFlags = field.getAccessFlags();
        String name = field.getName();
        String descriptor = field.getDescriptor();
        
        ConstantValue constValue = field.getConstantValue();
        if (constValue != null) {
            String constValueString = constValue.getItem().getValueString();
            
            formatter.writeField(accFlags, name, descriptor, constValueString);
        } else {
            formatter.writeField(accFlags, name, descriptor);
        }
    }
}
