package sg.edu.nus.iss.phoenix.schedule.delegate;

import java.sql.SQLException;
import java.util.List;
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
     * show all the created year
     * @return 
     */
    public List<Year> reviewExistingYear() throws SQLException {
        return service.reviewSelectYear();
    }

}
