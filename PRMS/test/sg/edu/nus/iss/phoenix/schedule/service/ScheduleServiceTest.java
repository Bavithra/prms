/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.schedule.service;

import java.lang.reflect.Method;
import java.sql.SQLException;
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
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import org.mockito.MockitoAnnotations;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.radioprogram.entity.RadioProgram;
import sg.edu.nus.iss.phoenix.schedule.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.schedule.entity.Year;

/**
 *
 * @author linby
 */
public class ScheduleServiceTest {

    @Mock
    ScheduleService scheduleService;
    @Mock
    ReviewSelectScheduleService rsService;

    public ScheduleServiceTest() {
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
        ProgramSlot programSlot = new ProgramSlot();
        RadioProgram radioProgram = new RadioProgram();
        programSlot.setId(1);
        radioProgram.setAll("TestProgram", "TestDescription", Time.valueOf("00:30:00"));
        String dateString = "2016-10-10 20:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        programSlot.setStartDateTime(LocalDateTime.parse(dateString, formatter));
        programSlot.setRadioProgram(radioProgram);
        User presenter = new User();
        presenter.setAll("TestPresenter", "tdd", "TestPresenter", "presenter");
        User producer = new User();
        producer.setAll("TestProducer", "tdd", "TestProducer", "producer");
        programSlot.setPresenter(presenter);
        programSlot.setProducer(producer);
        List<ProgramSlot> list = new ArrayList<>();
        list.add(programSlot);
        Mockito.when(rsService.reviewSelectSchedule()).thenReturn(list);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCheckOverlapEquals() throws Exception {
        System.out.println("testCheckOverlapEquals");
        ProgramSlot programSlot = new ProgramSlot();
        String dateString = "2016-10-10 19:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        programSlot.setStartDateTime(LocalDateTime.parse(dateString, formatter));
        RadioProgram radioProgram = new RadioProgram();
        radioProgram.setAll("TestProgram", "TestDescription", Time.valueOf("00:30:00"));
        programSlot.setRadioProgram(radioProgram);
        //test
        assertEquals(checkProgramSlotOverlaps(programSlot), false);
    }
    
    @Test
    public void testCheckOverlapBoundry() throws Exception {
        System.out.println("testCheckOverlapBoundry");
        ProgramSlot programSlot = new ProgramSlot();
        String dateString = "2016-10-10 19:39";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        programSlot.setStartDateTime(LocalDateTime.parse(dateString, formatter));
        RadioProgram radioProgram = new RadioProgram();
        radioProgram.setAll("TestProgram", "TestDescription", Time.valueOf("00:30:00"));
        programSlot.setRadioProgram(radioProgram);
        //test
        assertEquals(checkProgramSlotOverlaps(programSlot), false);
    }
    
     @Test
    public void testCheckOverlapInclude() throws Exception {
        System.out.println("testCheckOverlapInclude");
        ProgramSlot programSlot = new ProgramSlot();
        String dateString = "2016-10-10 19:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        programSlot.setStartDateTime(LocalDateTime.parse(dateString, formatter));
        RadioProgram radioProgram = new RadioProgram();
        radioProgram.setAll("TestProgram", "TestDescription", Time.valueOf("01:30:00"));
        programSlot.setRadioProgram(radioProgram);
        //test
        assertEquals(checkProgramSlotOverlaps(programSlot), true);
    }

    private boolean checkProgramSlotOverlaps(ProgramSlot programSlot) throws SQLException {
        if (programSlot != null) {
            for (ProgramSlot existingProgramSlot : rsService.reviewSelectSchedule()) {

                LocalDateTime existingEndDateTime = existingProgramSlot.getStartDateTime().plusHours(existingProgramSlot.getRadioProgram().getTypicalDuration().getHours());
                existingEndDateTime = existingEndDateTime.plusMinutes(existingProgramSlot.getRadioProgram().getTypicalDuration().getMinutes());

                LocalDateTime endDateTime = programSlot.getStartDateTime().plusHours(programSlot.getRadioProgram().getTypicalDuration().getHours());
                endDateTime = endDateTime.plusMinutes(programSlot.getRadioProgram().getTypicalDuration().getMinutes());

                if ((programSlot.getStartDateTime().isBefore(existingEndDateTime) || programSlot.getStartDateTime().isEqual(existingEndDateTime))
                        && (endDateTime.isAfter(existingEndDateTime) || endDateTime.isEqual(existingEndDateTime))) {
                    return true;
                }
            }
        }
        return false;
    }

}
