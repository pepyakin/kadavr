/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.knott.kadavr.metadata;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Утилиты, которые могут быть полезны при
 * считывании файлов класса Java.
 * @author Sergey
 */
public class ClassFileReader extends DataInputStream {

    /**
     * Создать экземпляр ридера классов.
     * @param in
     */
    public ClassFileReader(InputStream in) {
        super(in);
    }

    /**
     * Считывает безнаковое число размером в байт.
     * @return
     * @throws IOException Если возникнет ошибка ввода вывода.
     */
    public int readU1() throws IOException {
        return readUnsignedByte();
    }

    /**
     * Считывает безнаковое число размером в два байта.
     */
    public int readU2() throws IOException {
        return readUnsignedShort();
    }

    /**
     * Считывает безнаковое число размером в четыре байта.
     * @return
     * @throws IOException Если возникнет ошибка ввода вывода.
     */
    public long readU4() throws IOException {
        return readInt() & 0xFFFFFFFF;
    }
}
