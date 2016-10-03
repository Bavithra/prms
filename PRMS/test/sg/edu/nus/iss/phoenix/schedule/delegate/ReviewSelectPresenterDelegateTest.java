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
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import org.mockito.MockitoAnnotations;
import sg.edu.nus.iss.phoenix.authenticate.dao.UserDao;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.user.delegate.UserDelegate;

/**
 *
 * @author Deepak
 */
public class ReviewSelectPresenterDelegateTest {
    @Mock
    UserDelegate instance;
    @Mock
    UserDao userDAO;
    @Mock
    User presenter;
    @Captor
    ArgumentCaptor argCaptor;
    
    
    
    public ReviewSelectPresenterDelegateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws NotFoundException {
        MockitoAnnotations.initMocks(this);
       presenter.setAll("TestPresenter", "tdd", "TestPresenter", "presenter");
       Mockito.when(instance.loadUser("TestPresenter")).thenReturn(presenter);
        
    }
    
    @After
    public void tearDown() {
        instance = null;
        presenter = null;
    }

    /**
     * Test of reviewSelectPresenter method, of class ReviewSelectPresenterDelegate.
     */
    @Test
    public void testReviewSelectPresenter() throws Exception {
        System.out.println("reviewSelectPresenter");
        instance.processCreate(presenter);
        User expUser = instance.loadUser("TestPresenter");
         Mockito.verify(instance).loadUser((String) argCaptor.capture());
         assertNotNull(expUser);
    }
    
}
