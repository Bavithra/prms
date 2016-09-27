/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.schedule.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sg.edu.nus.iss.phoenix.core.dao.DBConstants;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.schedule.dao.ScheduleDAO;
import sg.edu.nus.iss.phoenix.schedule.entity.ProgramSlot;

/**
 * n
 *
 * @author linby
 *
 * Schedule Data Access Object (DAO). This class contains all database handling
 * that is needed to permanently store and retrieve Schedule object instances.
 */
public class ScheduleDAOImpl implements ScheduleDAO {

    Connection connection;

    @Override
    public void create(ProgramSlot valueObject) throws SQLException {
        String sql = "";
        PreparedStatement stmt = null;
        openConnection();
        try {
            sql = "INSERT INTO `program-slot` (`dateOfProgram`, `duration`, `startTime`,`presenter`,`producer`,`program-name`) VALUES (?,?,?,?,?,?); ";
            stmt = connection.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(valueObject.getDateOfProgram().getTime()));
            stmt.setTime(2, valueObject.getDuration());
            stmt.setTime(3, valueObject.getStartTime());
            stmt.setString(4, valueObject.getPresenter());
            stmt.setString(5, valueObject.getProducer());
            stmt.setString(6, valueObject.getProgramName());
            int rowcount = stmt.executeUpdate();
            if (rowcount != 1) {
                throw new SQLException("PrimaryKey Error when insert DB!");
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            closeConnection();
        }
    }

    @Override
    public List<ProgramSlot> load(ProgramSlot valueObject) throws NotFoundException, SQLException {
        if (valueObject.getDateOfProgram() == null) {
            // System.out.println("Can not select without Primary-Key!");
            throw new NotFoundException("Can not select without Primary-Key!");
        }

        String sql = "SELECT * FROM `program-slot` WHERE (`dateOfProgram` = ?); ";
        PreparedStatement stmt = null;
        openConnection();
        try {
            stmt = connection.prepareStatement(sql);
            return listQuery(stmt);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            closeConnection();
        }
    }

    @Override
    public List<ProgramSlot> loadAll() throws SQLException {
        String sql = "SELECT * FROM `program-slot`; ";
        PreparedStatement stmt = null;
        openConnection();
        try {
            stmt = connection.prepareStatement(sql);
            return listQuery(stmt);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            closeConnection();
        }
    }

    @Override
    public void save(ProgramSlot valueObject) throws SQLException,NotFoundException {
        String sql = "UPDATE `program-slot` SET `duration` = ?, `dateOfProgram` = ?, `startTime`=?, `program-name`=?, `presenter`=?, `producer`=? WHERE `id` = ? ; ";
        PreparedStatement stmt = null;
        openConnection();
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setTime(1, valueObject.getDuration());
            stmt.setDate(2, new java.sql.Date(valueObject.getDateOfProgram().getTime()));
            stmt.setTime(3, valueObject.getStartTime());
            stmt.setString(4, valueObject.getProgramName());
            stmt.setString(5, valueObject.getPresenter());
            stmt.setString(6, valueObject.getProducer());
            //condition parameter
            stmt.setInt(7, valueObject.getId());
            int rowcount = stmt.executeUpdate();
            if (rowcount == 0) {
                // System.out.println("Object could not be saved! (PrimaryKey not found)");
                throw new NotFoundException(
                        "Object could not be saved! (PrimaryKey not found)");
            }
            if (rowcount > 1) {
                // System.out.println("PrimaryKey Error when updating DB! (Many objects were affected!)");
                throw new SQLException(
                        "PrimaryKey Error when updating DB! (Many objects were affected!)");
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            closeConnection();
        }
    }

    @Override
    public void delete(ProgramSlot valueObject) throws SQLException {
        String sql = "DELETE FROM `program-slot` WHERE `id` = ? ;";
        PreparedStatement stmt = null;
        openConnection();
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, valueObject.getId());
            int rowcount = stmt.executeUpdate();
            System.out.println("" + rowcount);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            closeConnection();

        }
    }

    @Override
    public void deleteAll(Connection conn) throws SQLException {
        String sql = "DELETE FROM `program-slot`";
        PreparedStatement stmt = null;
        openConnection();
        try {
            stmt = connection.prepareStatement(sql);
            int rowcount = stmt.executeUpdate();
            System.out.println("" + rowcount);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            closeConnection();

        }
    }

    @Override
    public int countAll() throws SQLException {
        String sql = "SELECT count(*) FROM `program-slot`";
        PreparedStatement stmt = null;
        ResultSet result = null;
        int allRows = 0;
        openConnection();
        try {
            stmt = connection.prepareStatement(sql);
            result = stmt.executeQuery();

            if (result.next()) {
                allRows = result.getInt(1);
            }
        } finally {
            if (result != null) {
                result.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            closeConnection();
        }
        return allRows;
    }

    protected List<ProgramSlot> listQuery(PreparedStatement stmt) throws SQLException {

        ArrayList<ProgramSlot> searchResults = new ArrayList<ProgramSlot>();
        ResultSet result = null;
        openConnection();
        try {
            result = stmt.executeQuery();

            while (result.next()) {
                ProgramSlot temp = new ProgramSlot();
                temp.setId(result.getInt("id"));
                temp.setDateOfProgram(result.getDate("dateOfProgram"));
                temp.setDuration(result.getTime("duration"));
                temp.setStartTime(result.getTime("startTime"));
                temp.setPresenter(result.getString("presenter"));
                temp.setProducer(result.getString("producer"));
                temp.setProgramName(result.getString("program-name"));
                searchResults.add(temp);
            }

        } finally {
            if (result != null) {
                result.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            closeConnection();
        }

        return (List<ProgramSlot>) searchResults;
    }

    private void openConnection() {
        try {
            Class.forName(DBConstants.COM_MYSQL_JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            this.connection = DriverManager.getConnection(DBConstants.dbUrl,
                    DBConstants.dbUserName, DBConstants.dbPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
