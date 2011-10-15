package org.knott.kadavr.metadata.attr;

import java.io.IOException;
import org.knott.kadavr.metadata.ClassFileReader;
import org.knott.kadavr.metadata.ClassItem;
import org.knott.kadavr.metadata.ConstPool;

/**
 *
 * @author Sergey
 */
public class Exceptions extends Attribute {

    private ClassItem[] exceptions;
    
    /**
     * Возвратить исключение по
     * заданному индексу.
     * @return Возращает запись по 
     * заданному индексу.
     */
    public ClassItem get(int i) {
        return exceptions[i];
    }
    
    /**
     * Возвратить количество записей.
     */
    public int count() {
        return exceptions.length;
    }
    
    @Override
    public void read(ConstPool pool, ClassFileReader dis)
            throws IOException {
        int len = dis.readU2();
        exceptions = new ClassItem[len];
        
        for (int i = 0; i < len; i++) {
            exceptions[i] = pool.getClass(dis.readU2());
        }
    }

    @Override
    public String getName() {
        return "Exceptions";
    }
}
