package Model.dao;

import Model.bean.PhongBan;
import Connection.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhongBanDAO {
    public List<PhongBan> getAllPhongban() {
        List<PhongBan> list = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        try {
            String sql = "SELECT * FROM phongban";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new PhongBan(
                        rs.getString("IDPB"),
                        rs.getString("Tenpb"),
                        rs.getString("Mota")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public PhongBan getPhongbanById(String idpb) {
        Connection conn = DBConnection.getConnection();
        try {
            String sql = "SELECT * FROM phongban WHERE IDPB = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idpb);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new PhongBan(
                        rs.getString("IDPB"),
                        rs.getString("Tenpb"),
                        rs.getString("Mota")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updatePhongban(PhongBan pb) {
        Connection conn = DBConnection.getConnection();
        try {
            String sql = "UPDATE phongban SET Tenpb = ?, Mota = ? WHERE IDPB = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pb.getTenpb());
            ps.setString(2, pb.getMota());
            ps.setString(3, pb.getIdpb());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
