package sg.edu.nus.iss.phoenix.core.dao;

import sg.edu.nus.iss.phoenix.authenticate.dao.RoleDao;
import sg.edu.nus.iss.phoenix.authenticate.dao.UserDao;
import sg.edu.nus.iss.phoenix.authenticate.dao.impl.RoleDaoImpl;
import sg.edu.nus.iss.phoenix.authenticate.dao.impl.UserDaoImpl;
import sg.edu.nus.iss.phoenix.radioprogram.dao.ProgramDAO;
import sg.edu.nus.iss.phoenix.radioprogram.dao.impl.ProgramDAOImpl;
import sg.edu.nus.iss.phoenix.schedule.dao.ScheduleDAO;
import sg.edu.nus.iss.phoenix.schedule.dao.YearDAO;
import sg.edu.nus.iss.phoenix.schedule.dao.impl.ScheduleDAOImpl;
import sg.edu.nus.iss.phoenix.schedule.dao.impl.YearDAOImpl;

public class DAOFactoryImpl implements DAOFactory {

    private UserDao userDAO = new UserDaoImpl();
    private RoleDao roleDAO = new RoleDaoImpl();
    private ProgramDAO rpdao = new ProgramDAOImpl();
    private ScheduleDAO sdDAO = new ScheduleDAOImpl();
    private YearDAO yearDAO= new YearDAOImpl();

    @Override
    public UserDao getUserDAO() {
        // TODO Auto-generated method stub
        return userDAO;
    }

    @Override
    public RoleDao getRoleDAO() {
        // TODO Auto-generated method stub
        return roleDAO;
    }

    @Override
    public ProgramDAO getProgramDAO() {
        // TODO Auto-generated method stub
        return rpdao;
    }

    @Override
    public ScheduleDAO getScheduleDAO() {
        return sdDAO;
    }

    public YearDAO getYearDAO() {
        return yearDAO;
    }


}
