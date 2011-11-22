/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.knott.kadavr.metadata.attr;

import java.io.IOException;
import org.knott.kadavr.metadata.ClassFileReader;
import org.knott.kadavr.metadata.ConstPool;

/**
 *
 * @author knott
 */
public class GenericAttribute extends Attribute {
    
    private String name;

    public GenericAttribute(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        
        this.name = name;
    }

    @Override
    public void read(ConstPool pool, ClassFileReader dis) throws IOException {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public String getName() {
        return name;
    }
    
}
