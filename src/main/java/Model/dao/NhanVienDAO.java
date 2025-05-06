package Model.dao;

import Model.bean.NhanVien;
import Connection.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO {
    public List<NhanVien> getAllNhanvien() {
        List<NhanVien> list = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        try {
            String sql = "SELECT * FROM nhanvien";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new NhanVien(
                        rs.getString("IDNV"),
                        rs.getString("Hoten"),
                        rs.getString("IDPB"),
                        rs.getString("Diachi")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<NhanVien> getNhanvienByPhongban(String idpb) {
        List<NhanVien> list = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        try {
            String sql = "SELECT * FROM nhanvien WHERE IDPB = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idpb);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new NhanVien(
                        rs.getString("IDNV"),
                        rs.getString("Hoten"),
                        rs.getString("IDPB"),
                        rs.getString("Diachi")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<NhanVien> searchNhanvienByField(String field, String keyword) {
        List<NhanVien> list = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        try {
            // Dynamically construct the SQL query based on the field
            String sql = "SELECT * FROM nhanvien WHERE " + field + " LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new NhanVien(
                        rs.getString("IDNV"),
                        rs.getString("Hoten"),
                        rs.getString("IDPB"),
                        rs.getString("Diachi")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insertNhanvien(NhanVien nv) {
        Connection conn = DBConnection.getConnection();
        try {
            String sql = "INSERT INTO nhanvien(IDNV, Hoten, IDPB, Diachi) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nv.getIdnv());
            ps.setString(2, nv.getHoten());
            ps.setString(3, nv.getIdpb());
            ps.setString(4, nv.getDiachi());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateNhanvien(NhanVien nv) {
        Connection conn = DBConnection.getConnection();
        try {
            String sql = "UPDATE nhanvien SET Hoten = ?, IDPB = ?, Diachi = ? WHERE IDNV = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nv.getHoten());
            ps.setString(2, nv.getIdpb());
            ps.setString(3, nv.getDiachi());
            ps.setString(4, nv.getIdnv());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteNhanvien(String idnv) {
        Connection conn = DBConnection.getConnection();
        try {
            String sql = "DELETE FROM nhanvien WHERE IDNV = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idnv);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<NhanVien> getNhanvienByDepartment(String idpb) {
        List<NhanVien> list = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        try {
            String sql = "SELECT * FROM nhanvien WHERE IDPB = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idpb); // Use parameterized query to avoid SQL syntax errors
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new NhanVien(
                        rs.getString("IDNV"),
                        rs.getString("Hoten"),
                        rs.getString("IDPB"),
                        rs.getString("Diachi")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public NhanVien getNhanvienByIdnv(String idnv) {
        List<NhanVien> list = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        try {
            String sql = "SELECT * FROM nhanvien WHERE IDNV = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idnv);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new NhanVien(
                        rs.getString("IDNV"),
                        rs.getString("Hoten"),
                        rs.getString("IDPB"),
                        rs.getString("Diachi")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
