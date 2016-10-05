/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.user.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import sg.edu.nus.iss.phoenix.authenticate.dao.UserDao;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;

/**
 *
 * @author linby
 */
public class UserServiceTest {

    @Mock
    UserDao userDao;

    @InjectMocks
    UserService service;

    public UserServiceTest() {
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
        User user = new User();
        user.setAll("TestGuy", "password", "TestGuy Doe", "manager");
        List<User> list = new ArrayList<>();
        list.add(user);
        //mock set up
        Mockito.when(userDao.loadAll()).thenReturn(list);
        Mockito.when(userDao.getObject("TestGuy")).thenReturn(user);
        Mockito.doThrow(new SQLException("programExist")).when(userDao).delete(Mockito.any());
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of reviewSelectUser method, of class UserService.
     */
    @Test
    public void testReviewSelectUser() throws Exception {
        System.out.println("reviewSelectUser");
        User user = new User();
        user.setAll("TestGuy", "password", "TestGuy Doe", "manager");
        List<User> expResult = new ArrayList<>();
        expResult.add(user);
        //test
        List<User> result = service.reviewSelectUser();
        assertEquals(expResult.size(), result.size());
        Mockito.verify(userDao).loadAll();
    }

    /**
     * Test of loadUser method, of class UserService.
     */
    @Test
    public void testLoadUser() throws Exception {
        System.out.println("loadUser");
        String id = "TestGuy";
        User result = service.loadUser(id);
        assertEquals("TestGuy", result.getId());
        Mockito.verify(userDao).getObject(id);
    }

    @Test
    public void testDeleteUserWhenAssigned() throws Exception {
        System.out.println("testDeleteUserWhenAssigned");
        //test
        try {
            service.processDelete("TestGuy");
            Mockito.verify(userDao).delete(userDao.getObject("TestGuy"));
            Mockito.verify(userDao).getObject("TestGuy");
        } catch (SQLException e) {
            assertEquals("programExist", e.getMessage());
        }
    }

}
