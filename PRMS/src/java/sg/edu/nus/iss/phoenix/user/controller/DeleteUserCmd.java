/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.user.controller;

import at.nocturne.api.Action;
import at.nocturne.api.Perform;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.user.delegate.UserDelegate;

/**
 *
 * @author Samrat
 */
@Action("deleteUser")
public class DeleteUserCmd implements Perform {

    @Override
    public String perform(String path, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        UserDelegate userDelegate = new UserDelegate();
        String id = req.getParameter("id");
        try {
            userDelegate.processDelete(id);
        } catch (NotFoundException e) {
            e.printStackTrace();
            req.setAttribute("error", "The user is already deleted");
            return "/pages/error.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("error", "Cannot delete the user who is already assigned in schedule");
            return "/pages/error.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Fatal Exception:"+e.getMessage());
            return "/pages/error.jsp";
        }
        // Navigation
        List<User> data = userDelegate.reviewSelectUser();
        req.setAttribute("users", data);
        return "/pages/cruduser.jsp";
    }
}
