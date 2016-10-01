/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.user.delegate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sg.edu.nus.iss.phoenix.authenticate.entity.Role;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;

/**
 *
 * @author Suba Raj
 */
public class UserDelegateTest {
    
    public UserDelegateTest() {
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
     * Test of reviewSelectUser method, of class UserDelegate.
     */
    @Test
    public void testReviewSelectUser() {
        System.out.println("reviewSelectUser");
        UserDelegate instance = new UserDelegate();
        User user = new User();
        List<User> expResult = instance.reviewSelectUser();
        user.setAll("user", "pass", "User", "manager");
        expResult.add(user);
        
        List<User> result = instance.reviewSelectUser();
        assertNotSame(expResult.size(), result.size());
    }

    /**
     * Test of processCreate method, of class UserDelegate.
     */
    @Test
    public void testProcessCreate() throws Exception {
        System.out.println("processCreate");
        User user = new User();
        user.setAll("John", "password", "John Doe", "manager");
        UserDelegate instance = new UserDelegate();
        instance.processCreate(user);
    }

    /**
     * Test of processModify method, of class UserDelegate.
     */
    @Test
    public void testProcessModify() throws Exception {
        System.out.println("processModify");
        User user = new User();
        user.setId("Sam");
        UserDelegate instance = new UserDelegate();
        instance.processModify(user);
    }

    /**
     * Test of processDelete method, of class UserDelegate.
     */
    @Test
    public void testProcessDelete() throws Exception {
        System.out.println("processDelete");
        String id = "User1";
        UserDelegate instance = new UserDelegate();
        instance.processDelete(id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of loadUser method, of class UserDelegate.
     */
    @Test
    public void testLoadUser() throws Exception {
        System.out.println("loadUser");
        String id = "User1";
        UserDelegate instance = new UserDelegate();
        User expResult = new User();
        
        expResult.setAll(id, "password", "John Doe", "manager");
        instance.processCreate(expResult);

        User result = instance.loadUser(id);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getPassword(), result.getPassword());
    }
    
}
