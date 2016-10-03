/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.schedule.delegate;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import org.mockito.MockitoAnnotations;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.radioprogram.entity.RadioProgram;
import sg.edu.nus.iss.phoenix.schedule.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.user.delegate.UserDelegate;

/**
 *
 * @author Suba Raj
 */
public class ScheduleDelegateTest {

    ScheduleDelegate instance;
    ReviewSelectScheduleDelegate rsInstance;
    UserDelegate userInstance;
    ProgramSlot valueObject;

    public ScheduleDelegateTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        instance = new ScheduleDelegate();
        rsInstance = new ReviewSelectScheduleDelegate();
        userInstance = new UserDelegate();
        valueObject = new ProgramSlot();
        //create object part
        User presenter = new User();
        presenter.setAll("TestPresenter", "tdd", "TestPresenter", "presenter");
        User producer = new User();
        producer.setAll("TestProducer", "tdd", "TestProducer", "producer");
        RadioProgram radioProgram = new RadioProgram();
        radioProgram.setAll("testProgram", "It`s a testProgram", Time.valueOf("00:30:00"));
        //insert into database
        valueObject.setPresenter(presenter);
        valueObject.setProducer(producer);
        valueObject.setRadioProgram(radioProgram);
        String dateString = "1970-10-10 20:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        valueObject.setStartDateTime(LocalDateTime.parse(dateString, formatter));
    }

    @After
    public void tearDown() {
        //delete testing data
        instance = null;
        rsInstance = null;
        valueObject = null;
    }

    /**
     * Test of processCreateProgramSlot method, of class ScheduleDelegate.
     */
    @Test
    public void testProcessCreateProgramSlot() throws Exception {
        System.out.println("processCreateProgramSlot");
        //test
        int size = rsInstance.reviewSelectProgramSlot().size();
        instance.processCreateProgramSlot(valueObject);
        assertEquals(size + 1, rsInstance.reviewSelectProgramSlot().size());
    }

    /**
     * Test of processDeleteProgramSlot method, of class ScheduleDelegate.
     */
    @Test
    public void testProcessDeleteProgramSlot() throws Exception {
        System.out.println("processDeleteProgramSlot");
        //create object part

        //test
        List<ProgramSlot> list = rsInstance.reviewSelectProgramSlot();
        instance.processDeleteProgramSlot(list.get(list.size() - 1).getId());
        assertEquals(list.size() - 1, rsInstance.reviewSelectProgramSlot());
    }

    /**
     * Test of processUpdateProgramSlot method, of class ScheduleDelegate.
     */
    @Test
    public void testProcessUpdateProgramSlot() throws Exception {
        System.out.println("processUpdateProgramSlot");
        //create object part

        //test
        List<ProgramSlot> list = rsInstance.reviewSelectProgramSlot();
        ProgramSlot entity = list.get(list.size() - 1);
        entity.setStartDateTime(LocalDateTime.MIN);
        instance.processUpdateProgramSlot(entity);
    }

}
