package org.knott.kadavr;

import java.io.IOException;
import java.util.Stack;

/**
 * Классы потомки не являются потокобезопасными.
 * @author Sergey
 */
public class CodeFormatter {

    private IdentTextWriter writer;
    private Stack<Integer> identStack;

    /**
     * Создать экземпляр {@link CodeFormatter райтера кода}.
     * @param writer Райтер кода.
     */
    public CodeFormatter(IdentTextWriter writer) {
        if (writer == null) {
            throw new IllegalArgumentException("writer can't be null");
        }

        this.writer = writer;
        identStack = new Stack<Integer>();
    }

    /**
     * Получить текущий райтер.
     * @return
     */
    public IdentTextWriter getWriter() {
        return writer;
    }

    /**
     * Установить райтер.
     * @param writer
     */
    public void setWriter(IdentTextWriter writer) {
        if (writer == null) {
            throw new IllegalArgumentException("writer can't be null");
        }

        this.writer = writer;
    }

    /**
     * Вывести директиву.
     * @param directive
     * @throws IOException Если возникнет ошибка ввода вывода.
     */
    public void writeDirective(String directive) throws IOException {
        if (directive == null) {
            throw new IllegalArgumentException();
        }

        writer.append(directive);
    }

    /**
     * Вывести новую строку.
     * @throws IOException Если возникнет ошибка ввода вывода.
     */
    public void newline() throws IOException {
        writer.append('\n');
    }

    /**
     * Вывести пробельный символ.
     */
    public void whitespace() throws IOException {
        writer.append(' ');
    }

    /**
     * Вывести метку.
     * @param label Сама метка.
     * @throws IOException Если возникнет ошибка ввода вывода.
     */
    public void writeLabel(String label) throws IOException {
        if (label == null) {
            throw new IllegalArgumentException();
        }

        writer.append(label);
    }

    /**
     * Вывести инструкцию.
     * @param insn
     * @throws IOException Если возникнет ошибка ввода вывода.
     */
    public void writeInstruction(String insn) throws IOException {
        if (insn == null) {
            throw new IllegalArgumentException();
        }

        writer.append(insn);
    }

    /**
     * Вывести комментарий.
     */
    public void writeComment(String comment) throws IOException {
        if (comment == null) {
            throw new IllegalArgumentException();
        }

        writer.append(comment);
    }

    /**
     * Вывести идентификатор.
     * @param id
     * @throws IOException Если возникнет ошибка ввода вывода.
     */
    public void writeIdentifier(String id) throws IOException {
        if (id == null) {
            throw new IllegalArgumentException();
        }

        writer.append(id);
    }

    /**
     * Вывести текст.
     * @param str
     * @throws IOException Если возникнет ошибка ввода вывода.
     */
    public void write(String str) throws IOException {
        if (str == null) {
            throw new IllegalArgumentException();
        }

        writer.write(str);
    }

    /**
     * Вывести конкретное значение.
     * @param value
     * @throws IOException Если возникнет ошибка ввода вывода.
     */
    public void writeIntermediate(Number value) throws IOException {
        if (value == null) {
            throw new IllegalArgumentException();
        }

        writer.write(value.toString());
    }

    /**
     * Установить уровень идентации.
     * @param level Уровень идентации.
     */
    public void setIdentLevel(int level) {
        writer.setIdentLevel(level);
    }

    /**
     * Вернуть текущий уровень идентации.
     *
     * @return Текущий уровень идентации.
     */
    public int getIdentLevel() {
        return writer.getIdentLevel();
    }

    /**
     * Увеличить отступ на один уровень.
     */
    public void incIdent() {
        writer.incIdent();
    }

    /**
     * Уменьшить отступ на один уровень.
     */
    public void decIdent() {
        writer.decIdent();
    }

    /**
     * Сохранить текущую идентацию. После сохранения,
     * можно востановить с помощью {@link CodeFormatter#popIdent()}.
     */
    public void pushIdent() {
        identStack.push(writer.getIdentLevel());
    }

    /**
     * Востановить сохраннёную {@link CodeFormatter#pushIdent()} идентацию.
     */
    public void popIdent() {
        writer.setIdentLevel(identStack.pop());
    }
}
