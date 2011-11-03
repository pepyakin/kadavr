/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.knott.kadavr;

import junit.framework.TestCase;

/**
 *
 * @author Sergey
 */
public class LabelGenTest extends TestCase {
    
    public LabelGenTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of genLabelName method, of class LabelGen.
     */
    public void testGenLabel1() {
        LabelGen instance = new LabelGen();
        
        int pc = 3;
        String expResult = "L0003";
        String result = instance.genLabelName(pc);
        
        assertEquals(expResult, result);
        
        pc = 0xFFFF;
        expResult = "LFFFF";
        result = instance.genLabelName(pc);
        
        assertEquals(expResult, result);
    }
}
