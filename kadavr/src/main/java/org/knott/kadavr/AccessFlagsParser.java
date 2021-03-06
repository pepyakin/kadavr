package org.knott.kadavr;

import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.knott.kadavr.AccessFlag.*;

/**
 * Парсер для аттрибутов доступа. Этот
 * класс разбирает упакованное значение в
 * список флагов.
 *
 * @author Sergey
 */
public class AccessFlagsParser {

    /**
     * В качестве рефакторинга нужно будет разнести функциональность
     * разбора флагов(до списка AccessFlag) и формирование самой строки
     * из них.
     */

    private final List<AccessFlag> competence;

    /**
     * Создать экземпляр {@link AccessFlagsParser} с указанием какие
     * флаги могут быть обработанны.
     *
     * @param competence Список возможных флагов.
     */
    public AccessFlagsParser(List<AccessFlag> competence) {
        if (competence == null) {
            throw new IllegalArgumentException("competence can't be null");
        }

        this.competence = competence;
    }

    private AccessFlagsParser(AccessFlag ... flags) {
        competence = Arrays.asList(flags);
    }

    /**
     * Разобрать данные флаги доступа и возвратить
     * список установленных флагов.
     *
     * @param accessFlags Указанные флаги.
     * @return Список результатов разбора. Неразобранные
     * флаги не попадают в список и молча игнорируются.
     * Если ниодин флаг не разобран возвращается пустой список.
     */
    public List<AccessFlag> parse(int accessFlags) {
        List<AccessFlag> result = new LinkedList<AccessFlag>();

        // Просмотр всех флагов входящих в
        // компетенцию к данному парсеру.
        for (AccessFlag flag : competence) {
            if (flag.isSet(accessFlags)) {
                accessFlags &= ~flag.getFlag();
                result.add(flag);
            }
        }

        if (accessFlags != 0) {
            // accessFlags не равен нулю если остались не
            // разобранные флаги. Таких по плану не должно оставаться.
            // Однако спецификация говорит что мы должны их
            // молча игнорировать.

            // throw new RuntimeException();
        }

        return result;
    }

    /**
     * Сформировать законченную строку из представленных
     * модификаторов доступа.
     *
     * @param flags Список разобранных модификаторов.
     * @return Строковое представление модификаторов.
     */
    public String format(List<AccessFlag> flags) {
        flags = new ArrayList<AccessFlag>(flags);
        Collections.sort(flags, COMPARATOR);

        StringBuilder sb = new StringBuilder();
        boolean first = true;

        for (AccessFlag flag : flags) {
            if (first) {
                first = false;
            } else {
                sb.append(' ');
            }

            sb.append(flag.getMnemonic());
        }

        return sb.toString();
    }

    /**
     * Сформатировать строчку из указанных флагов
     * доступа.
     *
     * @param accessFlags Флаги доступа.
     * @return Строчку представляющую список
     * указанных модификаторов.
     */
    public String format(int accessFlags) {
        return format(parse(accessFlags));
    }

    /**
     * Парсер для модификаторов класса.
     */
    public static final AccessFlagsParser PARSER_CLASS =
            new AccessFlagsParser(
                    PUBLIC,
                    FINAL,
                    SUPER,
                    INTERFACE,
                    ABSTRACT);

    /**
     * Парсер для модификаторов полей класса.
     */
    public static final AccessFlagsParser PARSER_FIELD =
            new AccessFlagsParser(
                    PUBLIC,
                    PRIVATE,
                    PROTECTED,
                    STATIC,
                    FINAL,
                    VOLATILE,
                    TRANSIENT);

    /**
     * Парсер для модификаторов методов класса.
     */
    public static final AccessFlagsParser PARSER_METHOD =
            new AccessFlagsParser(
                    PUBLIC,
                    PRIVATE,
                    PROTECTED,
                    STATIC,
                    FINAL,
                    SYNCHRONIZED,
                    NATIVE,
                    ABSTRACT,
                    STRICT);

    /**
     * Парсер для модификаторов внутренних классов.
     */
    public static final AccessFlagsParser PARSER_INNER =
            new AccessFlagsParser(
                    PUBLIC,
                    PRIVATE,
                    PROTECTED,
                    STATIC,
                    FINAL,
                    INTERFACE,
                    ABSTRACT);

    private static final class PriorityComparator
            implements Comparator<AccessFlag> {

        @Override
        public int compare(AccessFlag o1, AccessFlag o2) {
            return o1.getPriority() - o2.getPriority();
        }
    }

    private static final Comparator<AccessFlag>
            COMPARATOR = new PriorityComparator();
}
