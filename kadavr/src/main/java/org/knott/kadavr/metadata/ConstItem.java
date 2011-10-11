package org.knott.kadavr.metadata;

import java.io.DataInputStream;
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

    public abstract int getTag();

    /**
     * Статический класс, который позволяет создавать
     * экземпляры соответсвующих билдеров.
     * 
     * @param <C> Конкретный класс, потомок {@link ConstItem},
     * экземпляр которого типа создаёт данный билдер.
     */
    static abstract class Reader<C extends ConstItem> {

        protected abstract C readItem(ClassFileReader dis) throws IOException;

        /**
         * Возвращает тег элемента {@link ConstItem}
         * который возращает функция {@link Reader#read(java.io.DataInputStream)}
         * @return Тег билдера.
         */
        abstract int getTag();

        /**
         * Считать элемент данного типа. 
         * @param dis Поток для чтения.
         * @return Считанный элемент константного пула.
         * @throws IOException 
         * @throws IllegalStateException Если тег элемента
         * не совпадает, с тегом данного билдера, будет выкинуто данное
         * исключение.
         */
        public final C checkRead(ClassFileReader dis) throws IOException {
            C readed = readItem(dis);

            if (readed.getTag() != getTag()) {
                throw new IllegalStateException();
            }

            return readed;
        }
    }
}
