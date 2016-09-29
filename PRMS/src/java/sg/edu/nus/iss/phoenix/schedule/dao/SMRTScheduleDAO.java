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
import sg.edu.nus.iss.phoenix.schedule.entity.SMRTRadioProgramSlot;

/**
 *
 * @author Samrat
 */
public interface SMRTScheduleDAO {
    //TODO - Documentation
    public abstract void create(SMRTRadioProgramSlot valueObject) throws SQLException;
    
    public abstract SMRTRadioProgramSlot load(int id) throws NotFoundException, SQLException;
    
    public abstract List<SMRTRadioProgramSlot> loadAll() throws SQLException;
    
    public abstract void save(SMRTRadioProgramSlot valueObject) throws NotFoundException,SQLException;
    
    public void delete(int id) throws SQLException;

    public abstract void deleteAll() throws SQLException;
}
