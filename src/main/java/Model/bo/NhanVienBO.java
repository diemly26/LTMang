package Model.bo;

import Model.bean.NhanVien;
import Model.dao.NhanVienDAO;

import java.util.List;

public class NhanVienBO {
    NhanVienDAO nhanvienDAO = new NhanVienDAO();

    public List<NhanVien> getAllNhanvien() {
        return nhanvienDAO.getAllNhanvien();
    }

    public List<NhanVien> getNhanvienByPhongban(String idpb) {
        return nhanvienDAO.getNhanvienByPhongban(idpb);
    }

    public List<NhanVien> searchNhanvienByField(String field, String keyword) {
        return nhanvienDAO.searchNhanvienByField(field, keyword);
    }
    public boolean addNhanvien(NhanVien nv) {
        return nhanvienDAO.insertNhanvien(nv);
    }

    public boolean updateNhanvien(NhanVien nv) {
        return nhanvienDAO.updateNhanvien(nv);
    }

    public boolean deleteNhanvien(String idnv) {
        return nhanvienDAO.deleteNhanvien(idnv);
    }



    public List<NhanVien> getNhanvienByDepartment(String idpb) {
        return nhanvienDAO.getNhanvienByDepartment(idpb);
    }

    public NhanVien getNhanvienByIdnv(String idnv) {
        return nhanvienDAO.getNhanvienByIdnv(idnv);
    }
}
