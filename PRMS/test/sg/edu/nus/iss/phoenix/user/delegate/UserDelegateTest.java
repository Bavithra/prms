/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.user.delegate;

import defaultExceptions.ProgramSlotExistsException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import sg.edu.nus.iss.phoenix.authenticate.dao.UserDao;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;

/**
 *
 * @author Suba Raj
 */
public class UserDelegateTest {

    @Mock
    UserDelegate instance;
    @Mock
    UserDao userDAO;
    @Mock
    User user;
    @Captor
    ArgumentCaptor argCaptor;

    public UserDelegateTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
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
        Mockito.verify(instance).loadUser((String)argCaptor.capture());
        assertNotNull(expUser);
    }

    @Test
    public void testIntIdForLoadUser() throws Exception {
        System.out.println("testIntIdForLoadUser");
        user.setAll("123", "password", "TestGuy Doe", "manager");
        Mockito.when(instance.loadUser("123")).thenReturn(user);
        ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);
        //test
        User expUser = instance.loadUser("123");
        Mockito.verify(instance).loadUser(arg.capture());
        assertNotNull(expUser);
    }

    @Test
    public void testDeleteUserWhenAssigned() throws Exception {
        System.out.println("testDeleteUserWhenAssigned");
//        Mockito.when(instance.processDelete("abc")).thenThrow(new Exception());
        Mockito.doThrow(new Exception("programExist")).when(instance).processDelete("TestGuy");
        //test
        try{
            instance.processDelete("TestGuy");
        }catch(Exception e){
            assertEquals("programExist",e.getMessage());
        }
    }

}
