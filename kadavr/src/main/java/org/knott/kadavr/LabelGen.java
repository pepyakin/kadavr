package org.knott.kadavr;

/**
 * Класс, предоставляющий услуги форматирования
 * строки метки для определённого указателя кода.
 *
 * @author Sergey
 */
public class LabelGen {

    /**
     * Количество нибблов - т.е. полубайтов.
     * Пусть PC имеет тип short.
     */
    private final int NIBBLE_COUNT = (2 * 2);

    /**
     * Возвращает имя метки для данного
     * смещения в коде.
     * @param pc Смещение в коде.
     * @return Имя метки для данного смещения.
     */
    public String genLabelName(int pc) {
        return "L" + getLeadingZeroStr(pc);
    }

    private String getLeadingZeroStr(int pc) {
        StringBuilder sb = new StringBuilder(NIBBLE_COUNT);
        sb.append(Integer.toHexString(pc).toUpperCase());
        while (sb.length() < 4) {
            sb.insert(0, '0');
        }
        return sb.toString();
    }
}
