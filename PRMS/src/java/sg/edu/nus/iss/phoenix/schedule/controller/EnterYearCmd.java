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
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.schedule.delegate.ReviewSelectScheduleDelegate;
import sg.edu.nus.iss.phoenix.schedule.delegate.ScheduleDelegate;
import sg.edu.nus.iss.phoenix.schedule.entity.Year;

/**
 *
 * @author linby
 */
@Action("enteryear")
public class EnterYearCmd implements Perform{

    @Override
    public String perform(String string, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ScheduleDelegate del = new ScheduleDelegate();
        Year year = new Year();
        year.setYear(Integer.valueOf(req.getParameter("year")));
        User user = (User) req.getSession().getAttribute("user");
        if(user != null) {
            year.setAssignedBy(user.getId());
        }
        del.processCreateYear(year);
        //show cryear screen and retrieve data
        ReviewSelectScheduleDelegate rsdel = new ReviewSelectScheduleDelegate();
        List<Year> years = rsdel.reviewExistingYear();
        if(years!=null){
            req.setAttribute("years", years);
        }
        return "/pages/cryear.jsp";
    }
    
}
