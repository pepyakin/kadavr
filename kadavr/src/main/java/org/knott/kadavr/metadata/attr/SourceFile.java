package org.knott.kadavr.metadata.attr;

import java.io.IOException;
import org.knott.kadavr.metadata.ClassFileReader;
import org.knott.kadavr.metadata.ConstPool;
import org.knott.kadavr.metadata.Utf8Item;

/**
 *
 * @author Sergey
 */
public class SourceFile extends Attribute {

    /**
     * Имя данного аттрибута.
     */
    public static final String NAME = "SourceFile";
    
    private Utf8Item name;

    /**
     * Возвратить имя файла для данного
     * атрибута.
     */
    public Utf8Item getSourceFile() {
        return name;
    }
    
    @Override
    public void read(ConstPool pool, ClassFileReader dis) 
            throws IOException {
        name = pool.getUtf(dis.readU2());
    }

    @Override
    public String getName() {
        return NAME;
    }
}
