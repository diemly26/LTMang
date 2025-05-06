package Model.bo;

import Model.bean.Admin;
import Model.dao.AdminDAO;

public class AdminBO {
    AdminDAO adminDAO = new AdminDAO();
    public Admin getAdminByUsernameAndPassword(String username, String password) {
        return adminDAO.getAdminByUsernameAndPassword(username, password);
    }
}
