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
import java.sql.Timestamp;
import java.util.List;
import sg.edu.nus.iss.phoenix.authenticate.dao.impl.UserDaoImpl;
import sg.edu.nus.iss.phoenix.core.dao.DBConstants;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.radioprogram.dao.impl.ProgramDAOImpl;
import sg.edu.nus.iss.phoenix.radioprogram.entity.RadioProgram;
import sg.edu.nus.iss.phoenix.schedule.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.schedule.dao.ScheduleDAO;

/**
 *
 * @author Samrat
 */
public class ScheduleDAOImpl implements ScheduleDAO {

    /**
     * *********************************
     */
    // Instance Variables
    /**
     * *********************************
     */
    Connection connection;

    /**
     * *********************************
     */
    // Constructor
    /**
     * *********************************
     */
    public ScheduleDAOImpl() {

    }

    /**
     * *********************************
     */
    // Interface Method Implementation
    /**
     * *********************************
     */
    @Override
    public void create(ProgramSlot valueObject) throws SQLException {
        String sql = "";
        PreparedStatement stmt = null;
        openConnection();
        try {
            sql = "INSERT INTO `radio-program-slot` (`startDateTime`, `radioProgram`, `presenter`,`producer`) VALUES (?,?,?,?); ";
            stmt = connection.prepareStatement(sql);
            stmt.setTimestamp(1, Timestamp.valueOf(valueObject.getStartDateTime()));
            stmt.setString(2, valueObject.getRadioProgram().getName());
            stmt.setString(3, valueObject.getPresenter().getId());
            stmt.setString(4, valueObject.getProducer().getId());
            int rowcount = stmt.executeUpdate();
            if (rowcount != 1) {
                throw new SQLException("PrimaryKey Error when insert DB!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Error while adding radio program slot.");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            closeConnection();
        }
    }

    @Override
    public ProgramSlot load(int id) throws NotFoundException, SQLException {
        String sql = "SELECT * FROM `radio-program-slot` WHERE `id` = ?; ";
        PreparedStatement stmt = null;

        ResultSet result = null;
        openConnection();

        stmt = connection.prepareStatement(sql);
        //condition parameter
        stmt.setInt(1, id);

        ProgramSlot radioProgramSlot = null;
        try {
            result = stmt.executeQuery();
            while (result.next()) {
                radioProgramSlot = getProgramSlot(result);
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
        return radioProgramSlot;
    }

    @Override
    public List<ProgramSlot> loadAll() throws SQLException {
        String sql = "SELECT * FROM `radio-program-slot`; ";
        PreparedStatement stmt = null;
        openConnection();
        try {
            stmt = connection.prepareStatement(sql);
            return listQuery(stmt);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Something went wrong while retrieving Program Slots.");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            closeConnection();
        }
    }

    @Override
    public void save(ProgramSlot valueObject) throws NotFoundException, SQLException {

        String sql = "UPDATE `radio-program-slot` SET `startDateTime` = ?, `radioProgram` = ?, `presenter`=?, `producer`=? WHERE `id` = ? ; ";
        PreparedStatement stmt = null;
        openConnection();
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setTimestamp(1, Timestamp.valueOf(valueObject.getStartDateTime()));
            stmt.setString(2, valueObject.getRadioProgram().getName());
            stmt.setString(3, valueObject.getPresenter().getId());
            stmt.setString(4, valueObject.getProducer().getId());

            //condition parameter
            stmt.setInt(5, valueObject.getId());

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
    public void delete(int id) throws NotFoundException, SQLException {
        String sql = "DELETE FROM `radio-program-slot` WHERE `id` = ? ;";
        PreparedStatement stmt = null;
        openConnection();
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            int rowcount = stmt.executeUpdate();
            System.out.println("" + rowcount);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Something went wrong while deleting program slot.");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            closeConnection();
        }
    }

    @Override
    public void deleteAll() throws SQLException {

    }

    /**
     * *********************************
     */
    // Private Method Implementation
    /**
     * *********************************
     */
    /**
     * Method to open the dB connection.
     */
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

    /**
     * Method to close the dB connection.
     */
    private void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Method to perform a list query.
     *
     * @param stmt The statement that needs to be executed to get the list of
     * items.
     * @return The list of program slots.
     * @throws SQLException
     * @throws NotFoundException
     */
    protected List<ProgramSlot> listQuery(PreparedStatement stmt) throws SQLException, NotFoundException {
        ArrayList<ProgramSlot> searchResults = new ArrayList<ProgramSlot>();

        ResultSet result = null;
        openConnection();
        try {
            result = stmt.executeQuery();
            while (result.next()) {
                ProgramSlot temp = getProgramSlot(result);
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
        return searchResults;
    }

    /**
     * Method to retrieve program slot from result set.
     *
     * @param result The result from which the program slot object needs to be
     * retrieved.
     * @return The program slot retrieved from the result set.
     * @throws SQLException
     * @throws NotFoundException
     */
    private ProgramSlot getProgramSlot(ResultSet result) throws SQLException, NotFoundException {

        UserDaoImpl userDaoImpl = new UserDaoImpl();
        ProgramDAOImpl programDAOImpl = new ProgramDAOImpl();

        ProgramSlot radioProgramSlot = new ProgramSlot();
        radioProgramSlot.setId(result.getInt("id"));
        radioProgramSlot.setStartDateTime(result.getTimestamp("startDateTime").toLocalDateTime());

        RadioProgram radioProgram = new RadioProgram(result.getString("radioProgram"));
        programDAOImpl.load(radioProgram);
        radioProgramSlot.setRadioProgram(radioProgram);

        radioProgramSlot.setPresenter(userDaoImpl.getObject(result.getString("presenter")));
        radioProgramSlot.setProducer(userDaoImpl.getObject(result.getString("producer")));

        return radioProgramSlot;
    }

    @Override
    public List<ProgramSlot> loadPresenterSchedule(String username) throws NotFoundException,SQLException {
        List<ProgramSlot> data = new ArrayList<>();
        String sql = "SELECT * FROM `radio-program-slot` WHERE `presenter` = ?; ";
        PreparedStatement stmt = null;

        ResultSet result = null;
        openConnection();

        stmt = connection.prepareStatement(sql);
        //condition parameter
        stmt.setString(1, username);

        try {
            result = stmt.executeQuery();
             while (result.next()) {
                ProgramSlot temp = getProgramSlot(result);
                data.add(temp);
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
        return data;
    }

    @Override
    public List<ProgramSlot> loadProducerSchedule(String username) throws NotFoundException,SQLException {
        List<ProgramSlot> data = null;
        String sql = "SELECT * FROM `radio-program-slot` WHERE `producer` = ?; ";
        PreparedStatement stmt = null;

        ResultSet result = null;
        openConnection();

        stmt = connection.prepareStatement(sql);
        //condition parameter
        stmt.setString(1, username);

        try {
            result = stmt.executeQuery();
             while (result.next()) {
                ProgramSlot temp = getProgramSlot(result);
                data.add(temp);
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
        return data;
    }
}
