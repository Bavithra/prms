/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.user.delegate;

import java.util.List;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.user.service.UserService;

/**
 *
 * @author Samrat
 */
public class UserDelegate {
    
    /***************************************************/
    // Instance Variables
    /***************************************************/
    private UserService service;
    
    /***************************************************/
    // Constructors
    /***************************************************/
    public UserDelegate() {
        service = new UserService();
    }
    
    /***************************************************/
    // Public Methods
    /***************************************************/
    
    /**
     * Method to get all the users present in the database.
     * @return List containing users present in database.
     */
    public List<User> reviewSelectUser() {
        return service.reviewSelectUser();
    }
}
