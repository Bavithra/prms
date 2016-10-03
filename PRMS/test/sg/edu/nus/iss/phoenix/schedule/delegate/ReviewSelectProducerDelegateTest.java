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
import org.mockito.MockitoAnnotations;
import sg.edu.nus.iss.phoenix.authenticate.dao.UserDao;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.user.delegate.UserDelegate;

/**
 *
 * @author Deepak
 */
public class ReviewSelectProducerDelegateTest {
    @Mock
    UserDelegate instance;
    @Mock
    UserDao userDAO;
    @Mock
    User producer;
    @Captor
    ArgumentCaptor argCaptor;
    
    public ReviewSelectProducerDelegateTest() {
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
       producer.setAll("TestProducer", "tdd", "TestProducer", "producer");
       Mockito.when(instance.loadUser("TestProducer")).thenReturn(producer);
    }
    
    @After
    public void tearDown() {
        instance = null;
        producer = null;
    }

    /**
     * Test of reviewProducer method, of class ReviewSelectProducerDelegate.
     */
    @Test
    public void testReviewProducer() throws Exception {
        System.out.println("reviewSelectProducer");
        instance.processCreate(producer);
        User expUser = instance.loadUser("TestProducer");
         Mockito.verify(instance).loadUser((String) argCaptor.capture());
         assertNotNull(expUser);
        
    }
    
}
