/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.schedule.dao;

import java.sql.SQLException;
import java.util.List;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.schedule.entity.ProgramSlot;

/**
 *
 * @author Samrat
 */
public interface ScheduleDAO {
    
    /**
     * Method to create a new program slot.
     * @param valueObject The program slot object that will be added to the dB.
     * @throws SQLException If something goes wrong during adding the slot.
     */
    public abstract void create(ProgramSlot valueObject) throws SQLException;
    
    /**
     * Method to load a program slot from the dB.
     * @param id The id of the program slot that needs to be loaded.
     * @return The program slot with all the parameters loaded.
     * @throws NotFoundException If a program slot is not found with the id.
     * @throws SQLException If something went wrong during the retrieval.
     */
    public abstract ProgramSlot load(int id) throws NotFoundException, SQLException;
    
    /**
     * Method to load all the program slots present in dB.
     * @return List containing all the program slots.
     * @throws SQLException If something went wrong during the retrieval.
     */
    public abstract List<ProgramSlot> loadAll() throws SQLException;
    
    /**
     * Method to modify an existing program slot.
     * @param valueObject The updated program slot with the modified parameters.
     * @throws NotFoundException If the program slot does not exist already in dB.
     * @throws SQLException If something went wrong during the modification.
     */
    public abstract void save(ProgramSlot valueObject) throws NotFoundException, SQLException;
    
    /**
     * Method to delete an existing program slot.
     * @param id The id of the program slot that needs to be deleted.
     * @throws NotFoundException If the program slot does not exist already in dB.
     * @throws SQLException If something went wrong during the deletion.
     */
    public void delete(int id) throws NotFoundException, SQLException;

    /**
     * Method to delete all the existing program slots.
     * @throws SQLException If something went wrong during the deletion.
     */
    public abstract void deleteAll() throws SQLException;
}
