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
import sg.edu.nus.iss.phoenix.schedule.entity.ProgramSlot;

/**
 *
 * @author Samrat
 */
public interface ScheduleDAO {
    //TODO - Documentation
    public abstract void create(ProgramSlot valueObject) throws SQLException;
    
    public abstract ProgramSlot load(int id) throws NotFoundException, SQLException;
    
    public abstract List<ProgramSlot> loadAll() throws SQLException;
    
    public abstract void save(ProgramSlot valueObject) throws NotFoundException,SQLException;
    
    public void delete(int id) throws SQLException;

    public abstract void deleteAll() throws SQLException;
}
