package org.knott.kadavr;

import java.io.IOException;

/**
 * Форматировщик вывода методов.
 *
 * @author Sergey
 */
public class MethodFormatter extends CodeFormatter {

    private AccessFlagsParser parser;

    /**
     * Создать экземпляр MethodFormatter.
     * @param writer Поток символов для вывода.
     * @param parser Разборщик модификаторов доступа.
     */
    public MethodFormatter(
            IdentTextWriter writer,
            AccessFlagsParser parser) {
        super(writer);

        if (parser == null) {
            throw new NullPointerException();
        }

        this.parser = parser;
    }

    /**
     * Создать экземпляр MethodFormatter.
     * @param writer Поток символов для вывода.
     */
    public MethodFormatter(
            IdentTextWriter writer) {
        this(writer, AccessFlagsParser.PARSER_METHOD);
    }

    /**
     * Начать декларацию метода.
     * @param accessFlags Установленные методу флаги доступа.
     * @param descriptor Дескриптор метода.
     * @param name Имя метода.
     */
    public void beginMethod(int accessFlags, String name, String descriptor)
            throws IOException {
        if (name == null) {
            throw new IllegalArgumentException();
        }

        if (descriptor == null) {
            throw new IllegalArgumentException();
        }

        writeDirective(".method");
        whitespace();
        writeDirective(parser.format(accessFlags));
        whitespace();
        writeIdentifier(name);
        writeIdentifier(descriptor);
        newline();
        pushIdent();
        setIdentLevel(1);
    }

    /**
     * Закончить декларацию метода.
     * @throws IOException Если возникнет ошибка ввода вывода.
     */
    public void endMethod()
            throws IOException {
        popIdent();
        writeDirective(".end method");
        newline();
        newline();
    }
}
