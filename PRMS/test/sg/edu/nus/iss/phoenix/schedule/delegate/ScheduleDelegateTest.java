/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.schedule.delegate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sg.edu.nus.iss.phoenix.schedule.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.schedule.entity.Year;

/**
 *
 * @author Suba Raj
 */
public class ScheduleDelegateTest {
    
    public ScheduleDelegateTest() {
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
     * Test of processCreateYear method, of class ScheduleDelegate.
     */
    @Test
    public void testProcessCreateYear() throws Exception {
        System.out.println("processCreateYear");
        Year valueObject = null;
        ScheduleDelegate instance = new ScheduleDelegate();
        instance.processCreateYear(valueObject);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processCreateProgramSlot method, of class ScheduleDelegate.
     */
    @Test
    public void testProcessCreateProgramSlot() throws Exception {
        System.out.println("processCreateProgramSlot");
        ProgramSlot valueObject = null;
        ScheduleDelegate instance = new ScheduleDelegate();
        instance.processCreateProgramSlot(valueObject);
    }

    /**
     * Test of processDeleteProgramSlot method, of class ScheduleDelegate.
     */
    @Test
    public void testProcessDeleteProgramSlot() throws Exception {
        System.out.println("processDeleteProgramSlot");
        int id = 0;
        ScheduleDelegate instance = new ScheduleDelegate();
        instance.processDeleteProgramSlot(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processUpdateProgramSlot method, of class ScheduleDelegate.
     */
    @Test
    public void testProcessUpdateProgramSlot() throws Exception {
        System.out.println("processUpdateProgramSlot");
        ProgramSlot valueObject = null;
        ScheduleDelegate instance = new ScheduleDelegate();
        instance.processUpdateProgramSlot(valueObject);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
