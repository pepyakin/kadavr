/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.knott.kadavr;

import junit.framework.TestCase;


/**
 *
 * @author knott
 */
public class CLIOptsTest extends TestCase {
    
    private CLIOpts opts;
    
    @Override
    protected void setUp() throws Exception {
        opts = new CLIOpts();
    }
    
    @Override
    protected void tearDown() throws Exception {
        
    }
    
    /**
     * Тестирование рапорта об ошибке,
     * когда соответсвующие аргументы 
     * не были заданы.
     */
    public void testParseWithoutArgs() {
        try {
            opts.parse();
            fail("No exception throwed");
        } catch (IllegalStateException e) { }
    }
    
    /**
     * Ожидать ошибку, если мы пытаемся получить
     * данные файлы не совершив разбора.
     */
    public void testGetInputFilesWithNoParse() {
        try {
            opts.getInputFiles();
            fail("No exception throwed");
        } catch (IllegalStateException e) { }
    }
}
