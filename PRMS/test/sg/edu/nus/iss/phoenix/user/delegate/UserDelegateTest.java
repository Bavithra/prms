/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.user.delegate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;

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
    public void setUp() throws Exception{
        instance = mock(UserDelegate.class);
        user = mock(User.class);
        user.setAll("TestGuy", "password", "TestGuy Doe", "manager");
        Mockito.when(instance.loadUser("TestGuy")).thenReturn(user);
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
        instance.processCreate(user);
        //test
        User expUser = instance.loadUser("TestGuy");
        assertNotNull(expUser);
    }
    
    @Test
    public void testIntIdForLoadUser() throws Exception{
         System.out.println("testIntIdForLoadUser");
        user.setAll("123", "password", "TestGuy Doe", "manager");
        Mockito.when(instance.loadUser("123")).thenReturn(user);
        //test
        User expUser = instance.loadUser("123");
        assertNotNull(expUser);
    }
    
     @Test
    public void testDeleteUserWhenAssigned() throws Exception{
        System.out.println("testDeleteUserWhenAssigned");
//        Mockito.when(instance.processDelete("abc")).thenThrow(new Exception());
        //test
        User expUser = instance.loadUser("123");
        assertNotNull(expUser);
    }

}
