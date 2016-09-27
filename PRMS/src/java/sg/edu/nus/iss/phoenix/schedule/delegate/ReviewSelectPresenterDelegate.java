/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.schedule.delegate;

import java.util.List;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.schedule.service.ReviewSelectUserService;

/**
 *
 * @author linby
 */
public class ReviewSelectPresenterDelegate {
    private ReviewSelectUserService service;

    public ReviewSelectPresenterDelegate() {
        service = new ReviewSelectUserService();
    }

    /**
     * retrieve all the Presenter
     * @return 
     */
    public List<User> reviewSelectPresenter() {
        return service.reviewSelectPresenter();
    }
}
