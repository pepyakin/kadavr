package org.knott.kadavr;

import java.io.IOException;

/**
 * Форматировщик вывода классов.
 *
 * @author Sergey
 */
public class ClassFormatter extends CodeFormatter {

    private AccessFlagsParser parser;

    /**
     * Создать экземпляр класса {@link CodeFormatter}.
     * @param writer
     * @param parser
     */
    public ClassFormatter(
            IdentTextWriter writer,
            AccessFlagsParser parser) {
        super(writer);
        if (parser == null) {
            throw new IllegalArgumentException();
        }

        this.parser = parser;
    }

    /**
     * Создать экземпляр класса {@link CodeFormatter}.
     * @param writer
     */
    public ClassFormatter(IdentTextWriter writer) {
        this(writer, AccessFlagsParser.PARSER_CLASS);
    }

    /**
     * Вывести декларацию имени исходного файла.
     * @param fileName Имя исходного файла.
     * @throws IOException Если возникнет ошибка ввода вывода.
     */
    public void writeSource(String fileName)
            throws IOException {
        if (fileName == null) {
            throw new IllegalArgumentException();
        }

        writeDirective(".source");
        whitespace();
        writeIdentifier(fileName);
        newline();
    }

    /**
     * Вывести декларацию класса.
     * @param accFlags
     * @param className Имя класса, не может быть null.
     * @throws IOException Если возникнет ошибка ввода вывода.
     */
    public void writeClass(int accFlags, String className)
            throws IOException {

        if (className == null) {
            throw new IllegalArgumentException();
        }

        writeDirective(".class");
        whitespace();
        writeDirective(parser.format(accFlags));
        whitespace();
        writeIdentifier(className);
        newline();
    }

    /**
     * Вывести декларацию класса-родителя.
     * @param superClass Имя родителя. Не может быть null.
     * @throws IOException Если возникнет ошибка ввода вывода.
     */
    public void writeSuper(String superClass)
            throws IOException {
        if (superClass == null) {
            throw new IllegalArgumentException();
        }

        writeDirective(".super");
        whitespace();
        writeIdentifier(superClass);
        newline();
    }

    /**
     * Вывести директиву реализации интерфейса.
     * @param iface Имя интерфейса, не может быть null.
     * @throws IOException Если возникнет ошибка ввода вывода.
     */
    public void writeImplements(String iface)
            throws IOException {
        if (iface == null) {
            throw new IllegalArgumentException();
        }

        writeDirective(".implements");
        whitespace();
        writeIdentifier(iface);
        newline();
    }
}
