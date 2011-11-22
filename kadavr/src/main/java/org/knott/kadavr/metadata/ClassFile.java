package org.knott.kadavr.metadata;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.knott.kadavr.metadata.attr.AttributeReader;
import org.knott.kadavr.metadata.attr.Attributes;

/**
 * Представляет собой разобранный файл
 * класса Java.
 *
 * @author Sergey
 */
public class ClassFile {

    private int major, minor;
    private ConstPool pool;
    private int accessFlags;

    private ClassItem thisClass;
    private ClassItem superClass;
    private ClassItem[] interfaces;

    private Field[] fields;
    private Method[] methods;
    private Attributes attributes;

    /**
     * Возвратить флаги доступа к данному классу.
     * @return
     */
    public int getAccessFlags() {
        return accessFlags;
    }

    /**
     * Возвратить список аттрибутов.
     * @return
     */
    public Attributes getAttributes() {
        //return Collections.unmodifiableList(attributes);
        return attributes;
    }

    /**
     * Возвратить список декларированных полей.
     * @return
     */
    public List<Field> getFields() {
        return Collections.unmodifiableList(Arrays.asList(fields));
    }

    /**
     * Возвратить список реализуемых интерфейсов.
     */
    public List<ClassItem> getInterfaces() {
        return Collections.unmodifiableList(Arrays.asList(interfaces));
    }

    /**
     * Возвратить список методов.
     * @return
     */
    public List<Method> getMethods() {
        return Collections.unmodifiableList(Arrays.asList(methods));
    }

    /**
     * Возвратить мажорную версию класса.
     * @return
     */
    public int getMajor() {
        return major;
    }

    /**
     * Возвратить минорную версию класса.
     * @return
     */
    public int getMinor() {
        return minor;
    }

    /**
     * Возвратить константный пул.
     * @return
     */
    public ConstPool getPool() {
        return pool;
    }

    /**
     * Возвратить супер тип данного класса.
     * @return
     */
    public ClassItem getSuperClass() {
        return superClass;
    }

    /**
     * Возвратить тип данного класса.
     * @return
     */
    public ClassItem getThisClass() {
        return thisClass;
    }

    /**
     * Возвратить имя текущего класса.
     * @return
     */
    public String getName() {
        return thisClass.getName().get();
    }

    /**
     * Возвратить имя супер класса.
     */
    public String getSuperName() {
        if (superClass == null)
            return null;

        return superClass.getName().get();
    }

    /**
     * Считать и заполнить данными данный объект.
     * @param stream
     * @throws IOException Если возникнет ошибка ввода вывода.
     */
    public void read(InputStream stream)
            throws IOException {
        ClassFileReader dis = new ClassFileReader(stream);

        int magic = (int)dis.readU4();
        if (magic != 0xCAFEBABE) {
            throw new IOException("wrong magic");
        }

        // Считать данные о версии.
        minor = dis.readU2();
        major = dis.readU2();

        // Считать константный пул.
        pool = ConstPool.read(ItemDispatcher.getDefaultDispatcher(), dis);
        pool.link();

        // Считать флаги доступа.
        accessFlags = dis.readU2();

        // Считать инфу о данном и базовом классе.
        thisClass = pool.getClass(dis.readU2());
        int superIdx = dis.readU2();
        if (superIdx != 0) {
            // Базовый класс может быть 0 в
            // случае с java/lang/Object.
            superClass = pool.getClass(superIdx);
        }

        // Считать какие интерфейсы определяет данный
        int ifaceCount = dis.readU2();
        interfaces = new ClassItem[ifaceCount];
        for (int i = 0; i < ifaceCount; i++) {
            interfaces[i] = pool.getClass(dis.readU2());
        }

        // Считать определения полей.
        int fieldCount = dis.readU2();
        fields = new Field[fieldCount];
        for (int i = 0; i < fieldCount; i++) {
            fields[i] = new Field();
            fields[i].read(pool, dis);
        }

        // Считать определения методов.
        int methodCount = dis.readU2();
        methods = new Method[methodCount];
        for (int i = 0; i < methodCount; i++) {
            methods[i] = new Method();
            methods[i].read(pool, dis);
        }

        AttributeReader attrReader = new AttributeReader(pool);
        attributes = attrReader.read(dis);
    }

    /**
     * Загрузить из файла.
     *
     * @param file
     * @return
     * @throws IOException Если возникнет ошибка ввода вывода.
     */
    public static ClassFile fromFile(String file)
            throws IOException {
        ClassFile c = new ClassFile();
        InputStream stream = new FileInputStream(file);
        c.read(stream);
        return c;
    }
}
