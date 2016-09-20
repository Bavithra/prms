/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.schedule.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sg.edu.nus.iss.phoenix.authenticate.dao.UserDao;
import sg.edu.nus.iss.phoenix.authenticate.entity.Role;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;

/**
 *
 * @author linby
 */
public class ReviewSelectUserService {

    DAOFactoryImpl factory;
    UserDao userDAO;

    public ReviewSelectUserService() {
        factory = new DAOFactoryImpl();
        userDAO = factory.getUserDAO();
    }

    public List<User> reviewSelectProducer() {
        List<User> list = null;
        try {
            User matchObject = new User();
            matchObject.setId(""); //set Id to nullString for DAOImpl search func
            ArrayList<Role> roles = new ArrayList<Role>();
            Role role = new Role();
            role.setRole("producer");
            roles.add(role);
            matchObject.setRoles(roles);
            list = userDAO.searchMatching(matchObject);
        } catch (SQLException ex) {
            Logger.getLogger(ReviewSelectUserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<User> reviewSelectPresenter() {
        List<User> list = null;
        try {
            User matchObject = new User();
            matchObject.setId(""); //set Id to nullString for DAOImpl search func
            ArrayList<Role> roles = new ArrayList<Role>();
            Role role = new Role();
            role.setRole("presenter");
            roles.add(role);
            matchObject.setRoles(roles);
            list = userDAO.searchMatching(matchObject);
        } catch (SQLException ex) {
            Logger.getLogger(ReviewSelectUserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
