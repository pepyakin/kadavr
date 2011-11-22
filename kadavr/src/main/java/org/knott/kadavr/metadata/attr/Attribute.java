package org.knott.kadavr.metadata.attr;

import java.io.IOException;
import org.knott.kadavr.metadata.ClassFileReader;
import org.knott.kadavr.metadata.ConstPool;

/**
 * Класс представляющий аттрибут.
 *
 * @author Sergey
 */
public abstract class Attribute {

    /**
     * Считать данные аттрибута из потока.
     * @param pool Константный пул класса.
     * @param dis Входной поток.
     */
    public abstract void read(ConstPool pool, ClassFileReader dis)
            throws IOException;

    /**
     * Возвратить имя атрибута.
     * @return Имя аттрибута.
     */
    public abstract String getName();
}
