package org.knott.kadavr.metadata;

import java.io.IOException;
import org.knott.kadavr.metadata.attr.AttributeReader;
import org.knott.kadavr.metadata.attr.Attributes;

/**
 * Класс представляет собой описание базового типа
 * для всех членов типа.
 *
 * @author Sergey
 */
public abstract class Member {

    protected int accessFlags;

    protected Utf8Item name;
    protected Utf8Item descriptor;

    protected Attributes attributes;

    /**
     * Возвратить флаги доступа к
     * данному члену.
     * @return
     */
    public int getAccessFlags() {
        return accessFlags;
    }

    /**
     * Возвратить строку-дескриптор данного члена.
     * @return
     */
    public String getDescriptor() {
        return descriptor.get();
    }

    /**
     * Возвратить имя данного члена.
     * @return
     */
    public String getName() {
        return name.get();
    }

    public Attributes getAttributes() {
        return attributes;
    }

    /**
     * Считать член из потока.
     */
    public void read(ConstPool pool, ClassFileReader dis)
            throws IOException {
        accessFlags = dis.readU2();
        name = pool.getUtf(dis.readU2());
        descriptor = pool.getUtf(dis.readU2());

        AttributeReader reader = new AttributeReader(pool);
        attributes = reader.read(dis);
    }
}
