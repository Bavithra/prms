/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.schedule.service;

import java.sql.SQLException;

import java.util.List;
import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.schedule.dao.ScheduleDAO;
import sg.edu.nus.iss.phoenix.schedule.dao.YearDAO;
import sg.edu.nus.iss.phoenix.schedule.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.schedule.entity.Year;

/**
 *
 * @author linby
 */
public class ReviewSelectScheduleService {

    DAOFactoryImpl factory;
    ScheduleDAO scheduledao;
    YearDAO yeardao;

    public ReviewSelectScheduleService() {
        factory = new DAOFactoryImpl();
        yeardao = factory.getYearDAO();
        scheduledao = factory.getScheduleDAO();
    }

    /**
     * Method to load all the annual schedules present in dB.
     * @return List containing all the annual schedules.
     * @throws SQLException If something went wrong during the retrieval.
     */
    public List<Year> reviewSelectYear() throws SQLException {
        List<Year> data = null;
        data = yeardao.loadAll();
        return data;
    }

    /**
     * Method to load all the program slots present in dB.
     * @return List containing all the program slots.
     * @throws SQLException If something went wrong during the retrieval.
     */
    public List<ProgramSlot> reviewSelectSchedule() throws SQLException {
        List<ProgramSlot> data = null;
        data = scheduledao.loadAll();
        return data;
    }

}
