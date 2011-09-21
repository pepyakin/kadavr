/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.knott.kadavr;

/**
 * Класс, позволяющий безболезненно получить
 * данные из коммандной строки.
 * @author knott
 */
public class CLIOpts {
    
    private String[] args;
    
    /**
     * Разобрать входящую строку.
     */
    public void parse() {
        if (getArgs() == null) {
            throw new IllegalStateException(
                    "Parsing without providing args");
        }
        
        throw new UnsupportedOperationException();
    }

    /**
     * @return Возвратить установленные
     * аргументы.
     */
    public String[] getArgs() {
        return args;
    }

    /**
     * Установить аргументы для разбора.
     * @param Аргументы коммандной строки.
     */
    public void setArgs(String[] args) {
        this.args = args;
    }
    
    /**
     * Получить массив с именами входных
     * файлов.
     * @return 
     */
    public String[] getInputFiles() {
        throw new UnsupportedOperationException();
    }
    
    public int getInputCount() {
        throw new UnsupportedOperationException();
    }
}
