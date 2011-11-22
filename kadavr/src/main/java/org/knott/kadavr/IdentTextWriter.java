package org.knott.kadavr;

import java.io.IOException;
import java.io.Writer;

/**
 * Класс позволяющий выводить текст с учётом идентации.
 * Класс не сильно заботиться о мультипоточности.
 * @author Sergey
 */
public class IdentTextWriter extends Writer {

    /**
     * Line feed символ. Подача строки. \n
     */
    private static final char LF = 0x000A;

    /**
     * Carriage return символ. Возврат каретки. \r
     */
    private static final char CR = 0x000D;

    /**
     * Стандартное количество отступов.
     */
    public static final int DEFAULT_IDENT = 4;

    private final Object syncLock;

    private final Writer underlying;
    private int currentIdent;
    private int identSize;
    private boolean startOfLine = true;

    private final String identString;

    /**
     * Создать экземпляр {@link IdentTextWriter}.
     * @param underlying
     */
    public IdentTextWriter(Writer underlying) {
        this(underlying, new Object[0]);
    }

    /**
     * Создать экземпляр райтера с объектом
     * на котором должна производится синхронизация.
     */
    public IdentTextWriter(Writer underlying, Object lock) {
        super(lock);
        if (lock == null) {
            throw new NullPointerException("lock can't be null");
        }

        this.syncLock = lock;
        this.underlying = underlying;

        identSize = DEFAULT_IDENT;
        identString = getIdentString(identSize);
    }

    private static String getIdentString(int identSize) {
        StringBuilder sb = new StringBuilder(identSize);
        for (int i = 0; i < identSize; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }

    /**
     * Установить уровень идентации.
     * @param level Должный уровень
     * идентации.
     */
    public void setIdentLevel(int level) {
        if (level < 0) {
            throw new IllegalArgumentException("level");
        }

        synchronized (syncLock) {
            this.currentIdent = level;
        }
    }

    /**
     * Возвратить установленный уровень
     * отступа.
     */
    public int getIdentLevel() {
        return currentIdent;
    }

    /**
     * Увеличить уровень отступа на 1.
     */
    public void incIdent() {
        synchronized (syncLock) {
            currentIdent++;
        }
    }

    /**
     * Уменьшить уровень отступа на 1.
     * Нельзя уменьшать идентацию меньше 0.
     */
    public void decIdent() {
        if (currentIdent == 0) {
            throw new IllegalStateException();
        }

        synchronized (syncLock) {
            currentIdent--;
        }
    }

    /**
     *
     * @param levels
     */
    private void writeIdent(int levels)
            throws IOException {
        for (int i = 0; i < levels; i++) {
            underlying.write(identString);
        }
    }

    private boolean detectCRLF(char[] cbuf, int i, int len) {
        char ch = cbuf[i];

        if (ch == CR) {
            // Если есть следующий символ, и он
            // равен LF, то сосчитать его тоже.

            if (i + 1 == len) {
                // Этот символ - последний. Значит тут конец строки.
                return true;
            } else {
                // Дальше символы есть,
                char nextChar = cbuf[i + 1];

                if (nextChar == LF) {
                    // Возвратим ложь, в следующий раз
                    // мы попадём в ветвь ( 1 ).
                    return false;
                } else {
                    // Мы тут одни. Значит конец строки.
                    return true;

                    // Только вот вопрос, а что если между
                    // CR и LF будет пробел?
                }
            }
        } else if (ch == LF) {
            // ( 1 )
            return true;
        }

        return false;
    }

    /**
     * Пишет в поток незаписанные байты.
     */
    private void writeRemain(char[] cbuf, int i, int newOffset)
            throws IOException {
        int toWrite = i - newOffset;
        if (toWrite > 0) {
            underlying.write(cbuf, newOffset, toWrite);
        }
    }

    private void writeUnsync(char[] cbuf, int off, int len)
            throws IOException {
        int newOffset = off;

        for (int i = 0; i < len; i++) {
            if (startOfLine) {
                writeRemain(cbuf, i, newOffset);
                writeIdent(currentIdent);
                startOfLine = false;
                newOffset += i - newOffset;
            }

            if (detectCRLF(cbuf, i, len)) {
                startOfLine = true;
            }
        }

        writeRemain(cbuf, off + len, newOffset);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(char[] cbuf, int off, int len)
            throws IOException {
        synchronized (syncLock) {
            writeUnsync(cbuf, off, len);
        }

        // underlying.write(cbuf, off, len);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void flush() throws IOException {
        underlying.flush();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws IOException {
        underlying.close();
    }
}
