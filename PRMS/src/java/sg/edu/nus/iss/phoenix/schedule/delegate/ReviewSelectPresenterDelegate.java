/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.schedule.delegate;

import java.sql.SQLException;
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
     * Method to load all the Presenter in dB.
     * @return List containing all the annual schedules.
     * @throws SQLException If something went wrong during the retrieval.
     */
    public List<User> reviewSelectPresenter() throws SQLException {
        return service.reviewSelectPresenter();
    }
}
