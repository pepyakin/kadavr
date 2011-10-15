package org.knott.kadavr.metadata.attr;

import java.io.IOException;
import org.knott.kadavr.metadata.ClassFileReader;
import org.knott.kadavr.metadata.ConstPool;

/**
 *
 * @author Sergey
 */
public class Synthetic extends Attribute {

    @Override
    public void read(ConstPool pool, ClassFileReader dis) 
            throws IOException {
        // Аттрибут пустой.
    }

    @Override
    public String getName() {
        return "Synthetic";
    }
    
}
