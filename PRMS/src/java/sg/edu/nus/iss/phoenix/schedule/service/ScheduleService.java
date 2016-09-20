/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.schedule.service;

import java.sql.SQLException;
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
            scheduleDAO.create(valueObject);
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
}
