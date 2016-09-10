/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.schedule.service;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public List<Year> reviewSelectYear() {
        List<Year> data = null;
        try {
            data = yeardao.loadAll();
        } catch (SQLException ex) {
            Logger.getLogger(ReviewSelectScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    public List<ProgramSlot> reviewSelectSchedule(){
        List<ProgramSlot> data = null;
        try{
            data= scheduledao.loadAll();
        }catch (SQLException ex) {
            Logger.getLogger(ReviewSelectScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

}
