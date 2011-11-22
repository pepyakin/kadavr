/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.knott.kadavr;

import java.io.IOException;
import org.knott.kadavr.metadata.Field;
import org.knott.kadavr.metadata.attr.ConstantValue;

/**
 * Дизассемблер объявлений полей класса.
 *
 * @author knott
 */
public class FieldDisasm {

    private Field field;
    private FieldFormatter formatter;

    /**
     * Мне кажется тут нужно сделать рефакторинг.
     * Тут главное что-бы поле передавалось не через
     * конструктор, а непосредственно в методе parse.
     */

    /**
     * Создать экземпляр класса {@link FieldDisasm}.
     * @param formatter Форматировщик вывода. Не может быть null.
     * @param field Поле для дизассемблирования. Не может быть null.
     */
    public FieldDisasm(FieldFormatter formatter, Field field) {
        if (field == null) {
            throw new IllegalArgumentException();
        }

        if (formatter == null) {
            throw new IllegalArgumentException();
        }

        this.field = field;
        this.formatter = formatter;
    }

    /**
     * Создать экземпляр класса {@link FieldDisasm}.
     * @param writer Поток символов вывода.
     * @param field Поле для дизассемблирования.
     */
    public FieldDisasm(IdentTextWriter writer, Field field) {
        this(new FieldFormatter(writer), field);
    }

    /**
     * Возвратить поле для разбора.
     * @return
     */
    public Field getField() {
        return field;
    }

    /**
     * Установить поле для разбора.
     * @param field
     */
    public void setField(Field field) {
        this.field = field;
    }

    /**
     * Возвратить форматировщик кода полей.
     * @return
     */
    public FieldFormatter getFormatter() {
        return formatter;
    }

    /**
     * Установить форматировщик кода полей.
     * @param formatter
     */
    public void setFormatter(FieldFormatter formatter) {
        this.formatter = formatter;
    }

    /**
     * Сделать разбор.
     * @throws IOException Если возникнет ошибка ввода вывода.
     */
    public void parse() throws IOException {
        if (field == null) {
            throw new NullPointerException();
        }

        if (formatter == null) {
            throw new NullPointerException();
        }

        int accFlags = field.getAccessFlags();
        String name = field.getName();
        String descriptor = field.getDescriptor();

        ConstantValue constValue = field.getConstantValue();
        if (constValue != null) {
            String constValueString = constValue.getItem().getValueString();

            formatter.writeField(accFlags, name, descriptor, constValueString);
        } else {
            formatter.writeField(accFlags, name, descriptor);
        }
    }
}
