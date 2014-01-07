/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sorteiobasic.sorteiodao;

import junit.framework.TestCase;

/**
 *
 * @author Luciano
 */
public class SorteioDAOTest extends TestCase {
    
    public SorteioDAOTest(String testName) {
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

    public void testAddSorteio() throws Exception {
        System.out.println("addSorteio");
        SorteioDAO instance = new SorteioDAO();
        boolean expResult = true;
        boolean result = instance.addSorteio();
        assertEquals(expResult, result);
       
    }
}
