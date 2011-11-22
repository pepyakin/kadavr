package org.knott.kadavr;

/**
 * Перечисление, описывающее всевозможные флаги
 * доступа которые могут быть применены к типу,
 * внутреннему типу, методу, полю, их строковое
 * представление и приоритет вывода.
 *
 * @author Sergey
 */
public enum AccessFlag {

    /**
     * Член доступен из всех пакетов.
     */
    PUBLIC(0x0001, "public", 0),

    /**
     * Член доступен только текущему типу.
     */
    PRIVATE(0x0002, "private", 0),

    /**
     * Член доступен только текущему типу и
     * его потомкам.
     */
    PROTECTED(0x0004, "protected", 0),

    /**
     * Член объявлен как static.
     */
    STATIC(0x0008, "static", 2),

    /**
     * Член с этим флагом нельзя переопределить
     * или наследовать.
     */
    FINAL(0x0010, "final", 1),

    /**
     * Указывает на то, что перед доступом к
     * члену, нужно захватить контроль над монитором
     * связанным с данным членом.
     */
    SYNCHRONIZED(0x0010, "synchronized", 3),

    /**
     * Используется в старых реализациях.
     */
    SUPER(0x0020, "super", 1),

    /**
     * Член не может быть закеширован.
     */
    VOLATILE(0x0040, "volatile", 4),

    /**
     * Член не поддаётся сериализации.
     */
    TRANSIENT(0x0080, "transient", 4),

    /**
     * Декларируется то, что реализация члена
     * представленна в машинном коде.
     */
    NATIVE(0x0100, "native", 3),

    /**
     * Указывает что данный тип - интерфейс.
     */
    INTERFACE(0x0200, "interface", 5),

    /**
     * Указывает что тип не может быть инстанциирован или
     * же метод обязан переопредён.
     */
    ABSTRACT(0x0400, "abstract", 1),

    /**
     * Указывает что вся арифметика с плавающей точкой
     * должна строго соответсвовать стандарту IEEE754.
     */
    STRICT(0x0800, "strictfp", 5);

    private final int flag;
    private final String mnemonic;
    private final int priority;

    private AccessFlag(int flag, String mnemonic, int priority) {
        this.flag = flag;
        this.mnemonic = mnemonic;
        this.priority = priority;
    }

    /**
     * Возвратить число, которое представляет данный
     * модификатор.
     * @return Число у которого один бит равен 1.
     */
    public int getFlag() {
        return flag;
    }

    /**
     * Возвратить строковое представление данного
     * модификатора.
     * @return Строковое представление, выводимое пользователю.
     */
    public String getMnemonic() {
        return mnemonic;
    }

    /**
     * Возвращает приоритет, служащий для сортировки
     * вывода модификаторов.
     * @return Приоритет текущего модификатора.
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Возвращает, содержится ли в числе данный флаг.
     * @param flags Число на проверку.
     * @return true если флаг установлен, иначе false.
     */
    public boolean isSet(int flags) {
        return ((flag & flags) != 0);
    }
}
