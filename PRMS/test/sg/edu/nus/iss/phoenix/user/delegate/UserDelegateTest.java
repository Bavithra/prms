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

    UserDelegate instance;
    User user;

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
        instance = new UserDelegate();
        user = new User();
    }

    @After
    public void tearDown() {
        instance = null;
        user = null;
    }

    /**
     * Test of reviewSelectUser method, of class UserDelegate.
     */
    @Test
    public void testReviewSelectUser() throws Exception {
        System.out.println("reviewSelectUser");
        user.setAll("John", "password", "John Doe", "manager");
        instance.processCreate(user);
        User expUser = instance.loadUser(user.getId());
        assertNotNull(expUser);
        //delete
        instance.processDelete(user.getId());
    }
    
    

    /**
     * Test of processCreate method, of class UserDelegate.
     */
    @Test
    public void testProcessCreate() throws Exception {
        System.out.println("processCreate");
        user.setAll("John", "password", "John Doe", "manager");
        instance.processCreate(user);
        User expUser = instance.loadUser("John");
        assertNotNull(expUser);
    }

    /**
     * Test of processModify method, of class UserDelegate.
     */
    @Test
    public void testProcessModify() throws Exception {
        System.out.println("processModify");
        user.setAll("John", "password", "John Doe", "manager");
        instance.processCreate(user);
        user.setId("John");
        user.setName("John Snow");
        user.setPassword("John");
        instance.processModify(user);
        User expUser = instance.loadUser("John");
        assertEquals(user.getName(), expUser.getName());
    }

    /**
     * Test of processDelete method, of class UserDelegate.
     */
    @Test
    public void testProcessDelete() throws Exception {
        System.out.println("processDelete");
        String id = "John";
        instance.processDelete(id);
        User expUser = null;
        try {
            expUser = instance.loadUser("John");
        } catch (Exception e) {
            assertNull(expUser);
        }

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
        User expResult = new User();

        expResult.setAll(id, "password", "John Doe", "manager");
//        instance.processCreate(expResult);

        User result = instance.loadUser(id);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getPassword(), result.getPassword());
    }
}
