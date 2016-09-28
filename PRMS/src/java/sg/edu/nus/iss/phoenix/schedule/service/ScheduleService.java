/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.schedule.service;

import com.sun.javafx.animation.TickCalculation;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.schedule.dao.ScheduleDAO;
import sg.edu.nus.iss.phoenix.schedule.dao.YearDAO;
import sg.edu.nus.iss.phoenix.schedule.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.schedule.entity.Year;

/**
 *
 * @author linby
 */
public class ScheduleService {

    DAOFactoryImpl factory;
    YearDAO yeardao;
    ScheduleDAO scheduleDAO;

    public ScheduleService() {
        factory = new DAOFactoryImpl();
        yeardao = factory.getYearDAO();
        scheduleDAO = factory.getScheduleDAO();
    }

    public void processCreateYear(Year valueObject) {
        try {
            yeardao.create(valueObject);
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void processCreateProgramSlot(ProgramSlot valueObject) {
        try {
            // First check for overlap
            if(!checkProgramSlotOverlaps(valueObject)) {
                // If there is no overlap, then proceed to create the program slot.
                scheduleDAO.create(valueObject);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void processUpdateProgramSlot(ProgramSlot valueObject) {
        try {
            scheduleDAO.save(valueObject);
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFoundException ex) {
            Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void processDeleteProgramSlot(ProgramSlot valueObject) {
        try {
            scheduleDAO.delete(valueObject);
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Method to check if the program slot passed overlaps with another program slot.     
     * @param programSlot The program slot that needs to be checked.
     * @return True if there is an overlap, else false.
     */
    private boolean checkProgramSlotOverlaps(ProgramSlot programSlot) throws NullPointerException {
        if(programSlot != null) {
            // Get all the existing program slots & run the loop
            ReviewSelectScheduleService reviewSelectScheduleService = new ReviewSelectScheduleService();
            for(ProgramSlot existingProgramSlot : reviewSelectScheduleService.reviewSelectSchedule()) {
                
                Date existingStartDate = existingProgramSlot.getDateOfProgram();
                existingStartDate.setTime(existingProgramSlot.getStartTime().getTime());
                
                Date existingEndDate = existingProgramSlot.getDateOfProgram();
                existingEndDate.setTime(existingProgramSlot.getStartTime().getTime() + existingProgramSlot.getDuration().getTime());
                
                // The current program slot
                Date currentStartDate = programSlot.getDateOfProgram();
                currentStartDate.setTime(programSlot.getStartTime().getTime());
                
                Date currentEndDate = programSlot.getDateOfProgram();
                currentEndDate.setTime(programSlot.getStartTime().getTime() + programSlot.getDuration().getTime());
                
                if((existingStartDate.before(currentEndDate)) && 
                        (existingEndDate.after(currentEndDate))) {
                    return true;
                }
            }
            // Return the value accordingly
            return false;
        }
        throw new NullPointerException();
    }
}
