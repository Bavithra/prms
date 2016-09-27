/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.schedule.controller;

import at.nocturne.api.Action;
import at.nocturne.api.Perform;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sg.edu.nus.iss.phoenix.schedule.delegate.ReviewSelectScheduleDelegate;
import sg.edu.nus.iss.phoenix.schedule.entity.ProgramSlot;

/**
 *
 * @author linby
 */
@Action("manageschedule")
public class ManageScheduleCmd implements Perform{

    @Override
    public String perform(String string, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ReviewSelectScheduleDelegate del = new ReviewSelectScheduleDelegate();
        List<ProgramSlot> data = del.reviewSelectProgramSlot();
        req.setAttribute("schedulelist", data);
        return "/pages/crudschedule.jsp";
    }
    
}
