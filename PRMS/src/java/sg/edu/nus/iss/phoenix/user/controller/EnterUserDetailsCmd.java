/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.user.controller;

import at.nocturne.api.Action;
import at.nocturne.api.Perform;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sg.edu.nus.iss.phoenix.authenticate.entity.Role;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.user.delegate.UserDelegate;

/**
 *
 * @author Samrat
 */
@Action("enterUser")
public class EnterUserDetailsCmd implements Perform {

    @Override
    public String perform(String path, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // Create the object
        UserDelegate userDelegate = new UserDelegate();
        User user = new User();
        user.setId(req.getParameter("id"));
        user.setPassword(req.getParameter("password"));
        user.setName(req.getParameter("name"));
        
        // Need to add the roles here
        ArrayList<Role> roleList = new ArrayList<>();
        String roles = req.getParameter("roles");
        String[] arrRoles = roles.trim().split(",");
        for (String role : arrRoles) {
            roleList.add(new Role(role.trim()));
        }
        user.setRoles(roleList);

        // Check if it is create or modify.
        String ins = (String) req.getParameter("ins");
        
        if (ins.equalsIgnoreCase("true")) {
            try {
                userDelegate.processCreate(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                userDelegate.processModify(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // Navigation
        List<User> data = userDelegate.reviewSelectUser();
        req.setAttribute("users", data);
        return "/pages/cruduser.jsp";
    }
}
