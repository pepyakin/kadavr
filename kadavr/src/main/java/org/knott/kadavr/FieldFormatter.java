/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.knott.kadavr;

import java.io.IOException;

/**
 * Форматировщик полей.
 *
 * @author knott
 */
public class FieldFormatter extends CodeFormatter {

    private AccessFlagsParser parser;

    /**
     * Создать экземпляр класса FieldFormatter.
     */
    public FieldFormatter(AccessFlagsParser parser, IdentTextWriter writer) {
        super(writer);
        if (parser == null) {
            throw new IllegalArgumentException();
        }

        this.parser = parser;
    }

    /**
     * Создать экземпляр класса FieldFormatter.
     * @param writer Райтер.
     */
    public FieldFormatter(IdentTextWriter writer) {
        this(AccessFlagsParser.PARSER_FIELD, writer);
    }

    /**
     * Вывести декларацию поля.
     * @param accessFlags Флаги доступа данного поля.
     * @param name Имя данного поля.
     * @param desc Дескриптор.
     * @param value Значение поля. Может быть null.
     * @throws IOException Если возникнет ошибка ввода вывода.
     */
    public void writeField(int accessFlags, String name, String desc, String value)
            throws IOException {
        if (name == null) {
            throw new IllegalArgumentException();
        }

        if (desc == null) {
            throw new IllegalArgumentException();
        }

        writeDirective(".field");
        whitespace();
        writeDirective(parser.format(accessFlags));
        whitespace();
        writeIdentifier(name);
        whitespace();
        writeIdentifier(desc);
        if (value != null) {
            write(" = ");
            writeIdentifier(value);
        }
        newline();
        newline();
    }

    /**
     * Вывести декларацию поля.
     * @param accessFlags Флаги доступа данного поля.
     * @param name Имя данного поля.
     * @param desc Дескриптор.
     * @throws IOException Если возникнет ошибка ввода вывода.
     */
    public void writeField(int accessFlags, String name, String desc) throws IOException {
        writeField(accessFlags, name, desc, null);
    }
}
