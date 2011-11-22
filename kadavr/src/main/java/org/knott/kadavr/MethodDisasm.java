package org.knott.kadavr;

import java.io.IOException;
import org.knott.kadavr.metadata.Method;

/**
 * Дизассемблер объявлений методов.
 *
 * @author Sergey
 */
public class MethodDisasm {

    private Method method;
    private MethodFormatter formatter;

    /**
     * Создать экземпляр класса MethodDisasm.
     * @param formatter
     * @param method
     */
    public MethodDisasm(MethodFormatter formatter, Method method) {
        this.method = method;
        this.formatter = formatter;
    }

    /**
     * Создать экземпляр класса MethodDisasm.
     * @param writer
     * @param method
     */
    public MethodDisasm(IdentTextWriter writer, Method method) {
        this(new MethodFormatter(writer), method);
    }

    /**
     * Создать экземпляр класса MethodDisasm.
     * @param writer Райтер.
     */
    public MethodDisasm(IdentTextWriter writer) {
        this(writer, null);
    }

    /**
     * Возвратить текущий форматировщик вывода.
     * @return Форматировщик.
     */
    public MethodFormatter getFormatter() {
        return formatter;
    }

    /**
     * Установить текущий форматировщик вывода.
     * @param formatter Форматировщик.
     */
    public void setFormatter(MethodFormatter formatter) {
        if (formatter == null) {
            throw new IllegalArgumentException();
        }

        this.formatter = formatter;
    }

    /**
     * Возвратить обрабатываемый метод.
     * @return Метод.
     */
    public Method getMethod() {
        return method;
    }

    /**
     * Установить обрабатываемый метод.
     * @param method
     */
    public void setMethod(Method method) {
        if (method == null) {
            throw new IllegalArgumentException();
        }

        this.method = method;
    }

    /**
     * Начать разоброр текущего метода.
     */
    public void beginParse()
            throws IOException {
        if (method == null) {
            throw new NullPointerException("method can't be null");
        }

        if (formatter == null) {
            throw new NullPointerException("formatter can't be null");
        }

        formatter.beginMethod(
                method.getAccessFlags(),
                method.getName(),
                method.getDescriptor());
    }

    /**
     * Закончить разбор текущего метода.
     * @throws IOException Если возникнет ошибка ввода вывода.
     */
    public void endParse() throws IOException {
        formatter.endMethod();
    }
}
