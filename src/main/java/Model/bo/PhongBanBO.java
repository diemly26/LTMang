package Model.bo;

import Model.bean.PhongBan;
import Model.dao.PhongBanDAO;

import java.util.List;

public class PhongBanBO {
    PhongBanDAO phongbanDAO = new PhongBanDAO();

    public List<PhongBan> getAllPhongban() {
        return phongbanDAO.getAllPhongban();
    }

    public boolean updatePhongban(PhongBan pb) {
        return phongbanDAO.updatePhongban(pb);
    }

    public PhongBan getPhongbanById(String idpb) {
        return phongbanDAO.getPhongbanById(idpb);
    }
}
