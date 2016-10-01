/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.user.service;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sg.edu.nus.iss.phoenix.authenticate.dao.UserDao;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;

/**
 *
 * @author Samrat
 */
public class UserService {

    /**
     * ************************************************
     */
    // Instance Variables
    /**
     * ************************************************
     */
    DAOFactoryImpl factory;
    UserDao userDao;

    /**
     * ************************************************
     */
    // Constructors
    /**
     * ************************************************
     */
    public UserService() {
        super();
        // TODO Auto-generated constructor stub
        factory = new DAOFactoryImpl();
        userDao = factory.getUserDAO();
    }

    /**
     * ************************************************
     */
    // Public Methods
    /**
     * ************************************************
     */
    
    /**
     * Method to get all user present in the database.
     * @return List containing all users present in database.
     */
    public List<User> reviewSelectUser() {
        List<User> data = null;
        try {
            data = userDao.loadAll();
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    /**
     * Method to create a user.
     * @param user The user object that needs to be created.
     * @throws SQLException If all the required parameters are not found.
     */
    public void processCreate(User user) throws SQLException {
            userDao.create(user);
    }

    /**
     * Method to modify an existing user.
     * @param user The user object that needs to be modified.
     * @throws NotFoundException If the user is not existing in database.
     * @throws SQLException If all the required parameters are not found.
     */
    public void processModify(User user) throws NotFoundException, SQLException {
            userDao.save(user);
    }

    /**
     * Method to delete an existing user.
     * @param id The id of the existing user.
     * @throws NotFoundException If the user is not found in database.
     * @throws SQLException If the user cannot be deleted since it is a foreign key.
     */
    public void processDelete(String id) throws NotFoundException, SQLException {
            User user = userDao.getObject(id);
            userDao.delete(user);
    }
    
    /**
     * Method to retrieve a user from database.
     * @param id The id of the user that needs to be retrieved.
     * @return The user object attached to the id.
     * @throws NotFoundException If the id is not found.
     */
    public User loadUser(String id) throws NotFoundException {
        try {
            return userDao.getObject(id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
