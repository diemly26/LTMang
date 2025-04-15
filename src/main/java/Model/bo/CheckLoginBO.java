package Model.bo;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.bean.Admin;
import Model.dao.CheckLoginDAO;

public class CheckLoginBO{
    CheckLoginDAO checkLoginDAO = new CheckLoginDAO();

    public boolean isValidUser(String userName, String password) throws ClassNotFoundException, SQLException{
        return checkLoginDAO.isExistUser(userName, password);
    }
    public Admin getAdmin(String username, String password) throws ClassNotFoundException, SQLException{
        return checkLoginDAO.getAdmin(username, password);
    }
}