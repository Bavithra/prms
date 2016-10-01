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
import sg.edu.nus.iss.phoenix.radioprogram.delegate.ReviewSelectProgramDelegate;
import sg.edu.nus.iss.phoenix.radioprogram.entity.RadioProgram;
import sg.edu.nus.iss.phoenix.schedule.delegate.ReviewSelectPresenterDelegate;
import sg.edu.nus.iss.phoenix.schedule.delegate.ReviewSelectProducerDelegate;
import sg.edu.nus.iss.phoenix.schedule.delegate.ReviewSelectScheduleDelegate;
import sg.edu.nus.iss.phoenix.schedule.entity.Year;

/**
 *
 * @author linby
 */
@Action("addeditschedule")
public class AddEditScheduleCmd implements Perform {

    @Override
    public String perform(String path, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        ReviewSelectProgramDelegate reviewSelectProgramDelegate = new ReviewSelectProgramDelegate();
        List<RadioProgram> radioProgramList = reviewSelectProgramDelegate.reviewSelectRadioProgram();
        req.setAttribute("programlist", radioProgramList);

        ReviewSelectScheduleDelegate reviewSelectScheduleDelegate = new ReviewSelectScheduleDelegate();
        ReviewSelectProducerDelegate reviewSelectProducerDelegate = new ReviewSelectProducerDelegate();
        ReviewSelectPresenterDelegate reviewSelectPresenterDelegate = new ReviewSelectPresenterDelegate();

        try {
            List<Year> yearList = reviewSelectScheduleDelegate.reviewExistingYear();
            req.setAttribute("yearList", yearList);
            List<User> producerList = reviewSelectProducerDelegate.reviewProducer();
            req.setAttribute("producerList", producerList);
            List<User> presenterList = reviewSelectPresenterDelegate.reviewSelectPresenter();
            req.setAttribute("presenterList", presenterList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/pages/createprogramslot.jsp";
    }
}
