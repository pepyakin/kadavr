package org.knott.kadavr;

import java.io.IOException;
import org.knott.kadavr.metadata.ClassFile;
import org.knott.kadavr.metadata.ClassItem;
import org.knott.kadavr.metadata.attr.*;

/**
 * Класс занимающийся записью аттрибутов класса
 * в директивы ассемблера.
 *
 * @author Sergey
 */
public class ClassDisasm {

    private ClassFormatter formatter;
    private ClassFile classFile;

    /**
     * Создать экземпляр класса {@link ClassDisasm}.
     *
     * @param formatter Форматировщик вывода классов.
     * @param classFile Файл класса.
     */
    public ClassDisasm(ClassFormatter formatter, ClassFile classFile) {
        if (formatter == null) {
            throw new NullPointerException();
        }

        this.formatter = formatter;
        this.classFile = classFile;
    }

    /**
     * Создать экземпляр класса {@link ClassDisasm}
     * с указанным райтером и файлом класса.
     * @param writer Выходной поток символов.
     * @param classFile Файл класса.
     */
    public ClassDisasm(IdentTextWriter writer, ClassFile classFile) {
        this(new ClassFormatter(writer), classFile);
    }

    /**
     * Создать экземпляр класса {@link ClassDisasm}.
     * @param writer Выходной поток символов.
     */
    public ClassDisasm(IdentTextWriter writer) {
        this(writer, null);
    }

    /**
     * Возвратить указанный форматировщик вывода.
     * @return
     */
    public ClassFormatter getFormatter() {
        return formatter;
    }

    /**
     * Возвратить указанный файл класса.
     * @return
     */
    public ClassFile getClassFile() {
        return classFile;
    }

    /**
     * Установить указанный файл класса для разбора.
     *
     * @param classFile Файл класса для разбора. Не может быть
     * null.
     */
    public void setClassFile(ClassFile classFile) {
        if (classFile == null) {
            throw new IllegalArgumentException();
        }

        this.classFile = classFile;
    }

    /**
     * Установить текущий форматировщик кода классов.
     *
     * @param formatter Форматировщик кода класса. Не может
     * быть null.
     */
    public void setFormatter(ClassFormatter formatter) {
        if (formatter == null) {
            throw new NullPointerException();
        }

        this.formatter = formatter;
    }

    /**
     * Распарсить класс и записать результат в представленный
     * форматировщик классов.
     * 
     * @throws IOException Выкидывается при ошибки
     * записи в форматировщик.
     */
    public void parse() throws IOException {
        if (classFile == null) {
            throw new NullPointerException("class not setted");
        }

        Attributes attrs = classFile.getAttributes();

        SourceFile source = (SourceFile)attrs.get(SourceFile.NAME);
        if (source != null) {

            // TODO: Посмотреть сюда.
            // Иначе, желательно добавить
            // .source outputfile.J
            formatter.writeSource(source.getSourceFile().get());
        }

        formatter.writeClass(classFile.getAccessFlags(), classFile.getName());

        String superName = classFile.getSuperName();
        formatter.writeSuper(superName);

        for (ClassItem iface : classFile.getInterfaces()) {
            formatter.writeImplements(iface.getName().get());
        }

        formatter.newline();
    }
}
