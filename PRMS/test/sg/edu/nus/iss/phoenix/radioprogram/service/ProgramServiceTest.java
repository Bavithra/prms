/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.radioprogram.service;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sg.edu.nus.iss.phoenix.radioprogram.entity.RadioProgram;

/**
 *
 * @author linby
 */
public class ProgramServiceTest {
    
    public ProgramServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of searchPrograms method, of class ProgramService.
     */
    @Test
    public void testSearchPrograms() {
        System.out.println("searchPrograms");
        RadioProgram rpso = null;
        ProgramService instance = new ProgramService();
        ArrayList<RadioProgram> expResult = null;
        ArrayList<RadioProgram> result = instance.searchPrograms(rpso);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findRPByCriteria method, of class ProgramService.
     */
    @Test
    public void testFindRPByCriteria() {
        System.out.println("findRPByCriteria");
        RadioProgram rp = null;
        ProgramService instance = new ProgramService();
        ArrayList<RadioProgram> expResult = null;
        ArrayList<RadioProgram> result = instance.findRPByCriteria(rp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findRP method, of class ProgramService.
     */
    @Test
    public void testFindRP() {
        System.out.println("findRP");
        String rpName = "";
        ProgramService instance = new ProgramService();
        RadioProgram expResult = null;
        RadioProgram result = instance.findRP(rpName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllRP method, of class ProgramService.
     */
    @Test
    public void testFindAllRP() {
        System.out.println("findAllRP");
        ProgramService instance = new ProgramService();
        ArrayList<RadioProgram> expResult = null;
        ArrayList<RadioProgram> result = instance.findAllRP();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processCreate method, of class ProgramService.
     */
    @Test
    public void testProcessCreate() {
        System.out.println("processCreate");
        RadioProgram rp = null;
        ProgramService instance = new ProgramService();
        instance.processCreate(rp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processModify method, of class ProgramService.
     */
    @Test
    public void testProcessModify() {
        System.out.println("processModify");
        RadioProgram rp = null;
        ProgramService instance = new ProgramService();
        instance.processModify(rp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processDelete method, of class ProgramService.
     */
    @Test
    public void testProcessDelete() throws Exception {
        System.out.println("processDelete");
        String name = "";
        ProgramService instance = new ProgramService();
        instance.processDelete(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
