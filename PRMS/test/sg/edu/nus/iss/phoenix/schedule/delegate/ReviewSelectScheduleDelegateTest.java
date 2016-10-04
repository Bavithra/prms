/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.schedule.delegate;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import sg.edu.nus.iss.phoenix.authenticate.dao.UserDao;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.radioprogram.entity.RadioProgram;
import sg.edu.nus.iss.phoenix.schedule.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.schedule.entity.Year;
import sg.edu.nus.iss.phoenix.schedule.service.ReviewSelectScheduleService;
import sg.edu.nus.iss.phoenix.user.delegate.UserDelegate;

/**
 *
 * @author linby
 */
public class ReviewSelectScheduleDelegateTest {
    
    @Mock
    ReviewSelectScheduleDelegate instance;
    @Mock
    UserDao userDAO;
    @Mock
    User presenter;
    @Mock
    User producer;
    @Mock
    ProgramSlot programSlot;
    @Mock
    RadioProgram radioProgram;
    @Mock
    ScheduleDelegate scheduleDelegate;
    
    @Captor
    ArgumentCaptor argCaptor;

      
    public ReviewSelectScheduleDelegateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        programSlot.setId(1);
        radioProgram.setAll("TestProgram","TestDescription", Time.valueOf("00:30:00"));
        String dateString = "2016-10-10 20:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        programSlot.setStartDateTime(LocalDateTime.parse(dateString, formatter));
        programSlot.setRadioProgram(radioProgram);
        presenter.setAll("TestPresenter", "tdd", "TestPresenter", "presenter");
        producer.setAll("TestProducer", "tdd", "TestProducer", "producer");
        programSlot.setPresenter(presenter);
        programSlot.setProducer(producer);
        List<ProgramSlot> list = new ArrayList<>();
        list.add(programSlot);
        Mockito.when(instance.reviewSelectProgramSlot()).thenReturn(list);
    }
    
    @After
    public void tearDown() {
        instance = null;
        presenter = null;
        producer = null;
        programSlot = null;
        radioProgram = null;
        scheduleDelegate = null;
    }

    /**
     * Test of reviewSelectProgramSlot method, of class ReviewSelectScheduleDelegate.
     */
    @Test
    public void testReviewSelectProgramSlot() throws Exception {
        System.out.println("reviewSelectProgramSlot");
        scheduleDelegate.processCreateProgramSlot(programSlot);
        //test
        ProgramSlot expUser = instance.reviewSelectProgramSlot().get(0);
        Mockito.verify(instance.reviewSelectProgramSlot().get(0));
        assertNotNull(expUser);
       
    }
    
}
