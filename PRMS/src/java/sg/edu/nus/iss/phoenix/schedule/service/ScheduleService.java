/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.schedule.service;

import defaultExceptions.ProgramSlotExistsException;
import java.sql.SQLException;
import java.time.LocalDateTime;
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

    /**
     * ********************************
     */
    // Instance Variables
    /**
     * ********************************
     */
    DAOFactoryImpl factory;
    YearDAO yeardao;
    ScheduleDAO scheduleDAO;

    /**
     * ********************************
     */
    // Constructor
    /**
     * ********************************
     */
    public ScheduleService() {
        factory = new DAOFactoryImpl();
        yeardao = factory.getYearDAO();
        scheduleDAO = factory.getScheduleDAO();
    }

    /**
     * ********************************
     */
    // Public Methods
    /**
     * ********************************
     */
    
    /**
     * Method to create a new annual schedule.
     *
     * @param valueObject The annual schedule object that will be added to the
     * dB.
     * @throws SQLException If something goes wrong during adding the slot.
     */
    public void processCreateYear(Year valueObject) throws SQLException {
        yeardao.create(valueObject);
    }

    /**
     * Method to create a new program slot.
     *
     * @param valueObject The program slot object that will be added to the dB.
     * @throws SQLException If something goes wrong during adding the slot.
     */
    public void processCreateProgramSlot(ProgramSlot valueObject) throws SQLException, ProgramSlotExistsException {
        // Here we need to check if a program slot already exists with the same time
        if(checkProgramSlotOverlaps(valueObject)) {
            throw new ProgramSlotExistsException("This program slot is already assigned");
        }else {
            scheduleDAO.create(valueObject);
        }
    }

    /**
     * Method to modify an existing program slot.
     *
     * @param valueObject The updated program slot with the modified parameters.
     * @throws NotFoundException If the program slot does not exist already in
     * dB.
     * @throws SQLException If something went wrong during the modification.
     */
    public void processUpdateProgramSlot(ProgramSlot valueObject) throws NotFoundException, SQLException, ProgramSlotExistsException {
        if(checkProgramSlotOverlaps(valueObject)) {
            throw new ProgramSlotExistsException("This program slot is already assigned");
        }else {
            scheduleDAO.save(valueObject);
        }
        
    }

    /**
     * Method to delete an existing program slot.
     *
     * @param id The id of the program slot that needs to be deleted.
     * @throws NotFoundException If the program slot does not exist already in
     * dB.
     * @throws SQLException If something went wrong during the deletion.
     */
    public void processDeleteProgramSlot(int id) throws NotFoundException, SQLException {
        scheduleDAO.delete(id);
    }

    /**
     * Method to delete the upcoming schedules attached to a radio program. Only
     * the upcoming schedules are deleted, & not the past ones.
     *
     * @param name The name of the radio program for which the schedules need to
     * be deleted.
     */
    public void deleteUpcomingProgramSlotsForRadioProgram(String name) {
        try {
            for (ProgramSlot programSlot : scheduleDAO.loadAll()) {
                if (programSlot.getRadioProgram().getName().equals(name)) {
                    // Here we have to add the check if it is already past today's date.
                    //scheduleDAO.delete(programSlot.getId());
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Method to check if the program slot passed overlaps with another program
     * slot.
     *
     * @param programSlot The program slot that needs to be checked.
     * @return True if there is an overlap, else false.
     */
    private boolean checkProgramSlotOverlaps(ProgramSlot programSlot) throws SQLException {
        if(programSlot != null) {
            // Get all the existing program slots & run the loop
            ReviewSelectScheduleService reviewSelectScheduleService = new ReviewSelectScheduleService();
            for(ProgramSlot existingProgramSlot : reviewSelectScheduleService.reviewSelectSchedule()) {
                
                LocalDateTime existingEndDateTime = existingProgramSlot.getStartDateTime().plusHours(existingProgramSlot.getRadioProgram().getTypicalDuration().getHours());
                existingEndDateTime = existingEndDateTime.plusMinutes(existingProgramSlot.getRadioProgram().getTypicalDuration().getMinutes());
                
                LocalDateTime endDateTime = programSlot.getStartDateTime().plusHours(programSlot.getRadioProgram().getTypicalDuration().getHours());
                endDateTime = endDateTime.plusMinutes(programSlot.getRadioProgram().getTypicalDuration().getMinutes());
                
                if((programSlot.getStartDateTime().isBefore(existingEndDateTime) || programSlot.getStartDateTime().isEqual(existingEndDateTime)) && 
                        (endDateTime.isAfter(existingEndDateTime) || endDateTime.isEqual(existingEndDateTime))) {
                    return true;
                }
            }
        }
        // Return the value accordingly
            return false;
    }
}
