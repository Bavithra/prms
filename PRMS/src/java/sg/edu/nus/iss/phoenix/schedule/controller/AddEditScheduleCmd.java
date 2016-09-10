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
import sg.edu.nus.iss.phoenix.authenticate.delegate.AuthenticateDelegate;
import sg.edu.nus.iss.phoenix.radioprogram.delegate.ReviewSelectProgramDelegate;
import sg.edu.nus.iss.phoenix.radioprogram.entity.RadioProgram;
import sg.edu.nus.iss.phoenix.schedule.delegate.ReviewSelectScheduleDelegate;
import sg.edu.nus.iss.phoenix.schedule.entity.Year;

/**
 *
 * @author linby
 */
@Action("addeditschedule")
public class AddEditScheduleCmd implements Perform{
   @Override
    public String perform(String path, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ReviewSelectProgramDelegate rspdel = new ReviewSelectProgramDelegate();
        ReviewSelectScheduleDelegate rssdel= new ReviewSelectScheduleDelegate();
        List<RadioProgram> rplist=rspdel.reviewSelectRadioProgram();
        List<Year> yearList=rssdel.reviewExistingYear();
        req.setAttribute("years", yearList);
        req.setAttribute("programlist",rplist);
        return "/pages/createprogramslot.jsp";
    }
}
