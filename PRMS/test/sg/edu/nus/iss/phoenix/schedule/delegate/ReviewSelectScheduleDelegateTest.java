/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.schedule.delegate;

import java.util.List;
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
 * @author linby
 */
public class ReviewSelectScheduleDelegateTest {
    
    public ReviewSelectScheduleDelegateTest() {
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
     * Test of reviewSelectProgramSlot method, of class ReviewSelectScheduleDelegate.
     */
    @Test
    public void testReviewSelectProgramSlot() throws Exception {
        System.out.println("reviewSelectProgramSlot");
        ReviewSelectScheduleDelegate instance = new ReviewSelectScheduleDelegate();
        List<ProgramSlot> expResult = null;
        List<ProgramSlot> result = instance.reviewSelectProgramSlot();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reviewExistingYear method, of class ReviewSelectScheduleDelegate.
     */
    @Test
    public void testReviewExistingYear() throws Exception {
        System.out.println("reviewExistingYear");
        ReviewSelectScheduleDelegate instance = new ReviewSelectScheduleDelegate();
        List<Year> expResult = null;
        List<Year> result = instance.reviewExistingYear();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
