/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.schedule.dao;

import java.sql.SQLException;
import java.util.List;
import sg.edu.nus.iss.phoenix.schedule.entity.Year;

/**
 *
 * @author linby
 */
public interface YearDAO {

    public abstract void create(Year valueObject) throws SQLException;

    public abstract List<Year> loadAll() throws SQLException;
}
