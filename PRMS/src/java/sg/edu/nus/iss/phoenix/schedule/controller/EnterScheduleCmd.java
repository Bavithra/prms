/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.schedule.controller;

import at.nocturne.api.Action;
import at.nocturne.api.Perform;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sg.edu.nus.iss.phoenix.radioprogram.delegate.ProgramDelegate;
import sg.edu.nus.iss.phoenix.schedule.delegate.ReviewSelectScheduleDelegate;
import sg.edu.nus.iss.phoenix.schedule.delegate.ScheduleDelegate;
import sg.edu.nus.iss.phoenix.schedule.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.user.delegate.UserDelegate;

/**
 *
 * @author linby
 */
@Action("enterprogramslot")
public class EnterScheduleCmd implements Perform{

    @Override
    public String perform(String string, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ScheduleDelegate scheduleDelegate = new ScheduleDelegate();
        UserDelegate userDelegate = new UserDelegate();
        ProgramDelegate programDelegate = new ProgramDelegate();
        
        ProgramSlot programSlot = new ProgramSlot();
        
        String dateString = req.getParameter("dateOfProgram");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        programSlot.setStartDateTime(LocalDateTime.parse(dateString, formatter));
        try {
           programSlot.setPresenter(userDelegate.loadUser(req.getParameter("presenter")));
           programSlot.setProducer(userDelegate.loadUser(req.getParameter("producer")));
           programSlot.setRadioProgram(programDelegate.loadRadioProgram(req.getParameter("program")));
        } catch(Exception e) {
            
        } finally {
            
        }
        
        String ins = (String) req.getParameter("ins");
        if (ins.equalsIgnoreCase("true")) {
             //insert
             scheduleDelegate.processCreateProgramSlot(programSlot);
        } else {
             //update
             String id =  req.getParameter("id");
             programSlot.setId(Integer.valueOf(id));
             scheduleDelegate.processUpdateProgramSlot(programSlot);
        }
         
        // Navigation
        ReviewSelectScheduleDelegate reviewSelectScheduleDelegate = new ReviewSelectScheduleDelegate();
        List<ProgramSlot> data = reviewSelectScheduleDelegate.reviewSelectProgramSlot();
        req.setAttribute("scheduleList", data);
        return "/pages/crudschedule.jsp";
    }
    
}
