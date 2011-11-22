package org.knott.kadavr;

import java.io.IOException;

/**
 * Форматировщик для вывода байткода.
 *
 * @author Sergey
 */
public class BytecodeFormatter
        extends CodeFormatter {

    private LabelGen labelGen;

    /**
     * Сконструировать экземпляр {@link BytecodeFormatter}.
     * @param writer Выходной поток.
     * @param labelGen Генератор меток перехода.
     */
    public BytecodeFormatter(IdentTextWriter writer, LabelGen labelGen) {
        super(writer);

        if (labelGen == null) {
            throw new NullPointerException();
        }

        this.labelGen = labelGen;
    }

    /**
     * Сконструировать экземпляр {@link BytecodeFormatter}.
     * @param writer Выходной поток.
     */
    public BytecodeFormatter(IdentTextWriter writer) {
        this(writer, new LabelGen());
    }

    /**
     * Вывести декларацию метки.
     *
     * @param pc Текущий указатель кода.
     * @throws IOException Если возникнет ошибка ввода вывода.
     */
    public void writeLabelDecl(int pc)
            throws IOException {
        writeLabel(labelGen.genLabelName(pc) + ":");
        whitespace();
    }

    /**
     * Вывести ссылку на метку.
     *
     * @param pc На что ссылка.
     * @throws IOException Если возникнет ошибка ввода вывода.
     */
    public void writeLabel(int pc) throws IOException {
        writeLabel(labelGen.genLabelName(pc));
        whitespace();
    }

    /**
     * Вывести директиву ограничения стэкового
     * пространства.
     *
     * @param limit Ограничение.
     * @throws IOException Если возникнет ошибка ввода вывода.
     */
    public void writeLimitStack(int limit) throws IOException {
        writeDirective(".limit");
        whitespace();
        writeDirective("stack");
        whitespace();
        writeIntermediate(limit);
        newline();
    }

    /**
     * Вывести директиву ограничения количества
     * локальных переменных.
     *
     * @param limit Ограничение.
     * @throws IOException Если возникнет ошибка ввода вывода.
     */
    public void writeLimitLocals(int limit) throws IOException {
        writeDirective(".limit");
        whitespace();
        writeDirective("locals");
        whitespace();
        writeIntermediate(limit);
        newline();
    }

    /**
     * Вывести операнд.
     *
     * @param valueString Значение.
     * @throws IOException Если возникнет ошибка ввода вывода.
     */
    public void writeOperand(String valueString) throws IOException {
        write(valueString);
    }
}
