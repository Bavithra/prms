/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.user.delegate;

import java.sql.SQLException;
import java.util.List;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.user.service.UserService;

/**
 *
 * @author Samrat
 */
public class UserDelegate {

    /**
     * ************************************************
     */
    // Constructors
    /**
     * ************************************************
     */
    public UserDelegate() {
    }

    /**
     * ************************************************
     */
    // Public Methods
    /**
     * ************************************************
     */
    
    /**
     * Method to get all the users present in the database.
     * @return List containing users present in database.
     */
    public List<User> reviewSelectUser() {
        UserService service = new UserService();
        return service.reviewSelectUser();
    }

    /**
     * Method to create a user.
     * @param user The user object that needs to be created.
     * @throws SQLException If all the required parameters are not found.
     */
    public void processCreate(User user) throws SQLException {
        UserService service = new UserService();
        service.processCreate(user);
    }

    /**
     * Method to modify an existing user.
     * @param user The user object that needs to be modified.
     * @throws NotFoundException If the user is not existing in database.
     * @throws SQLException If all the required parameters are not found.
     */
    public void processModify(User user) throws NotFoundException, SQLException {
        UserService service = new UserService();
        service.processModify(user);
    }

    /**
     * Method to delete an existing user.
     * @param id The id of the existing user.
     * @throws NotFoundException If the user is not found in database.
     * @throws SQLException If the user cannot be deleted since it is a foreign key.
     */
    public void processDelete(String id) throws NotFoundException, SQLException {
        UserService service = new UserService();
        service.processDelete(id);
    }
    
    /**
     * Method to retrieve a user from database.
     * @param id The id of the user that needs to be retrieved.
     * @return The user object attached to the id.
     * @throws NotFoundException If the id is not found.
     */
    public User loadUser(String id) throws NotFoundException {
        UserService service = new UserService();
        return service.loadUser(id);
    }
}
