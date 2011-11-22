package org.knott.kadavr.metadata;

import java.io.IOException;

/**
 * Абстрактный класс для всех элементов
 * пула констант.
 *
 * @author Sergey
 */
public abstract class ConstItem {

    /**
     * Этот метод вызывается в процессе
     * связывания. Процесс связывание инициирует
     * класс {@link ConstPool}. В процессе связывания
     * каждый потомок ConstItem должен будет связать
     * (загрузить) соответствующие экземпляры {@link ConstItem}
     * которые связанны с данным по индексам.
     *
     * @param pool Пул констант, который инициализировал
     * процесс связывания.
     */
    abstract void link(ConstPool pool);

    /**
     * Возвратить тег данного объекта.
     * @return
     */
    public abstract int getTag();

    /**
     * Прочитать данные данного объекта из потока.
     * @param dis Поток для чтения.
     * @throws IOException Если возникнет ошибка ввода вывода.
     */
    protected abstract void read(ClassFileReader dis)
            throws IOException;
}
