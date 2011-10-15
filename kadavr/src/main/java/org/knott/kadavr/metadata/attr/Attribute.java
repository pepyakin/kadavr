package org.knott.kadavr.metadata.attr;

import java.io.IOException;
import org.knott.kadavr.metadata.ClassFileReader;
import org.knott.kadavr.metadata.ConstPool;

/**
 * @author Sergey
 */
public abstract class Attribute {
    
    /**
     * Считать данные аттрибута из потока.
     * @param pool
     * @param dis 
     */
    public abstract void read(ConstPool pool, ClassFileReader dis)
            throws IOException;
    
    /**
     * Возвратить имя атрибута.
     * @return 
     */
    public abstract String getName();
}
