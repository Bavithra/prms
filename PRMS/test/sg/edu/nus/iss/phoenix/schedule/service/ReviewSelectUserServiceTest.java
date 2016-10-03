/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.schedule.service;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;

/**
 *
 * @author linby
 */
public class ReviewSelectUserServiceTest {
    
    public ReviewSelectUserServiceTest() {
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
     * Test of reviewSelectProducer method, of class ReviewSelectUserService.
     */
    @Test
    public void testReviewSelectProducer() throws Exception {
        System.out.println("reviewSelectProducer");
        ReviewSelectUserService instance = new ReviewSelectUserService();
        List<User> expResult = null;
        List<User> result = instance.reviewSelectProducer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reviewSelectPresenter method, of class ReviewSelectUserService.
     */
    @Test
    public void testReviewSelectPresenter() throws Exception {
        System.out.println("reviewSelectPresenter");
        ReviewSelectUserService instance = new ReviewSelectUserService();
        List<User> expResult = null;
        List<User> result = instance.reviewSelectPresenter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
