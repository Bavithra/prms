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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sg.edu.nus.iss.phoenix.schedule.delegate.ReviewSelectScheduleDelegate;
import sg.edu.nus.iss.phoenix.schedule.delegate.ScheduleDelegate;
import sg.edu.nus.iss.phoenix.schedule.entity.ProgramSlot;

/**
 *
 * @author linby
 */
@Action("enterprogramslot")
public class EnterScheduleCmd implements Perform{

    @Override
    public String perform(String string, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ScheduleDelegate del = new ScheduleDelegate();
        ProgramSlot programslot = new ProgramSlot();
        String date = req.getParameter("dateOfProgram");
        SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
        Time duration = Time.valueOf(req.getParameter("duration"));
        Time startTime= Time.valueOf(req.getParameter("startTime"));
//        try {
////            programslot.setDateOfProgram(sdf.parse(date));
////            programslot.setDuration(duration);
////            programslot.setPresenter(req.getParameter("presenter"));
////            programslot.setProducer(req.getParameter("producer"));
////            programslot.setProgramName(req.getParameter("program"));
////            programslot.setStartTime(startTime);
//        } catch (ParseException ex) {
//            Logger.getLogger(EnterScheduleCmd.class.getName()).log(Level.SEVERE, null, ex);
//        }
        String ins = (String) req.getParameter("ins");
        Logger.getLogger(getClass().getName()).log(Level.INFO,
                        "presenter: " + req.getParameter("presenter"));
         if (ins.equalsIgnoreCase("true")) {
             //insert
             del.processCreateProgramSlot(programslot);
        } else {
             //update
             String id =  req.getParameter("id");
             programslot.setId(Integer.valueOf(id));
             del.processUpdateProgramSlot(programslot);
        }
        ReviewSelectScheduleDelegate rsdel = new ReviewSelectScheduleDelegate();
        List<ProgramSlot> data = rsdel.reviewSelectProgramSlot();
        req.setAttribute("schedulelist", data);
        return "/pages/crudschedule.jsp";
    }
    
}
