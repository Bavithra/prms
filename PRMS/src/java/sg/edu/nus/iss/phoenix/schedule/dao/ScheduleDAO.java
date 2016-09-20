package sg.edu.nus.iss.phoenix.schedule.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.schedule.entity.ProgramSlot;

public interface ScheduleDAO {

    /**
     * insert into programslot
     * @param valueObject
     * @throws SQLException 
     */
    public abstract void create(ProgramSlot valueObject) throws SQLException;
    /**
     * when we need to search in the particular date period,input dateofProgram
     * to retrieve all the data scheduled in this date.
     *
     * @param valueObject
     * @throws NotFoundException
     * @throws SQLException
     */
    public abstract List<ProgramSlot> load(ProgramSlot valueObject)
            throws NotFoundException, SQLException;

    /**
     * retireve all the ProgramSlot data
     *
     * @return List<ProgramSlot>
     * @throws SQLException
     */
    public abstract List<ProgramSlot> loadAll() throws SQLException;

    /**
     * modify/udate existing programSlot
     *
     * @param valueObject
     * @throws NotFoundException
     * @throws SQLException
     */
    public abstract void save(ProgramSlot valueObject) throws NotFoundException,SQLException;

    /**
     * delete one particualr programSlot according to
     * program-name,date,startTime
     *
     * @param valueObject
     * @throws NotFoundException
     * @throws SQLException
     */
    public abstract void delete(ProgramSlot valueObject)
            throws SQLException;

    /**
     * delete all the data in program-slot table
     *
     * @param conn
     * @throws SQLException
     */
    public abstract void deleteAll(Connection conn) throws SQLException;

    /**
     * get the counts of the program-slot table
     *
     * @return
     * @throws SQLException
     */
    public abstract int countAll() throws SQLException;//FIXME reserve for divding page func 
}
