/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.user.delegate;

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
     *
     * @return List containing users present in database.
     */
    public List<User> reviewSelectUser() {
        UserService service = new UserService();
        return service.reviewSelectUser();
    }

    public void processCreate(User user) {
        UserService service = new UserService();
        service.processCreate(user);

    }

    public void processModify(User user) {
        UserService service = new UserService();
        service.processModify(user);

    }

    public void processDelete(String id) {
        UserService service = new UserService();
        service.processDelete(id);
    }
    
    public User loadUser(String id) throws NotFoundException {
        UserService service = new UserService();
        return service.loadUser(id);
    }
}
