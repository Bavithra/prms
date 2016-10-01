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
import sg.edu.nus.iss.phoenix.schedule.entity.Year;

/**
 *
 * @author linby
 */
@Action("manageyear")
public class ManageAnnualScheduleCmd implements Perform {

    @Override
    public String perform(String string, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ReviewSelectScheduleDelegate delegate = new ReviewSelectScheduleDelegate();
        try {
            List<Year> years = delegate.reviewExistingYear();
            if (years != null) {
                req.setAttribute("years", years);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/pages/cryear.jsp";
    }

}
