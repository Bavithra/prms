package sg.edu.nus.iss.phoenix.schedule.delegate;

import java.sql.SQLException;
import java.util.List;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.schedule.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.schedule.entity.Year;
import sg.edu.nus.iss.phoenix.schedule.service.ReviewSelectScheduleService;

public class ReviewSelectScheduleDelegate {

    private ReviewSelectScheduleService service;

    public ReviewSelectScheduleDelegate() {
        service = new ReviewSelectScheduleService();
    }

    /**
     * retrieve all the programSlot
     * @return 
     */
    public List<ProgramSlot> reviewSelectProgramSlot() throws SQLException {
        return service.reviewSelectSchedule();
    }
    
     /**
     * retrieve the programSlot which is assigned to current user
     * @return 
     */
    public List<ProgramSlot> reviewSelectMyProgramSlot(User user) throws NotFoundException,SQLException {
        return service.reviewSelectMyProgramSlot(user);
    }

    /**
     * show all the created year
     * @return 
     */
    public List<Year> reviewExistingYear() throws SQLException {
        return service.reviewSelectYear();
    }

}
