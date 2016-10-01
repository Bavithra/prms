/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.radioprogram.controller;

import at.nocturne.api.Action;
import at.nocturne.api.Perform;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.radioprogram.delegate.ProgramDelegate;
import sg.edu.nus.iss.phoenix.radioprogram.delegate.ReviewSelectProgramDelegate;
import sg.edu.nus.iss.phoenix.radioprogram.entity.RadioProgram;

/**
 *
 * @author boonkui
 */
@Action("deleterp")
public class DeleteRadioProgramCmd implements Perform {

    @Override
    public String perform(String path, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ProgramDelegate del = new ProgramDelegate();
        String name = req.getParameter("name");
        try {
            del.processDelete(name);
        } catch (NotFoundException e) {
            e.printStackTrace();
            req.setAttribute("error", "The program is already deleted");
            return "/pages/error.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("error", "Cannot delete the radio program that is already assigned in schedule");
            return "/pages/error.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Fatal Exception:"+e.getMessage());
            return "/pages/error.jsp";
        }

        ReviewSelectProgramDelegate rsDel = new ReviewSelectProgramDelegate();
        List<RadioProgram> data = rsDel.reviewSelectRadioProgram();
        req.setAttribute("rps", data);
        return "/pages/crudrp.jsp";
    }
}
