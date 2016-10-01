/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.schedule.delegate;

import java.sql.SQLException;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.schedule.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.schedule.entity.Year;
import sg.edu.nus.iss.phoenix.schedule.service.ScheduleService;

/**
 *
 * @author linby
 */
public class ScheduleDelegate {

    private ScheduleService service;

    public ScheduleDelegate() {
        service = new ScheduleService();
    }

    /**
     * Method to create a new annual schedule.
     *
     * @param valueObject The annual schedule object that will be added to the
     * dB.
     * @throws SQLException If something goes wrong during adding the slot.
     */
    public void processCreateYear(Year valueObject) throws SQLException {
        service.processCreateYear(valueObject);
    }

    /**
     * Method to create a new program slot.
     *
     * @param valueObject The program slot object that will be added to the dB.
     * @throws SQLException If something goes wrong during adding the slot.
     */
    public void processCreateProgramSlot(ProgramSlot valueObject) throws SQLException {
        service.processCreateProgramSlot(valueObject);
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
        service.processDeleteProgramSlot(id);
    }

    /**
     * Method to modify an existing program slot.
     *
     * @param valueObject The updated program slot with the modified parameters.
     * @throws NotFoundException If the program slot does not exist already in
     * dB.
     * @throws SQLException If something went wrong during the modification.
     */
    public void processUpdateProgramSlot(ProgramSlot valueObject) throws NotFoundException, SQLException {
        service.processUpdateProgramSlot(valueObject);
    }
}
