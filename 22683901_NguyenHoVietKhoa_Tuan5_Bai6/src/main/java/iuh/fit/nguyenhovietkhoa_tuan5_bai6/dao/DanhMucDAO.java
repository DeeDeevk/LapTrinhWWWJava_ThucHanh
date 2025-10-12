package iuh.fit.nguyenhovietkhoa_tuan5_bai6.dao;

import iuh.fit.nguyenhovietkhoa_tuan5_bai6.model.DanhMuc;
import iuh.fit.nguyenhovietkhoa_tuan5_bai6.util.DBUtil;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DanhMucDAO {
    private DBUtil dbutil;

    public DanhMucDAO(DataSource ds) {
        this.dbutil = new DBUtil(ds);
    }

    public List<DanhMuc> findAll() {
        List<DanhMuc> list = new ArrayList<>();
        String sql = "SELECT MADM, TENDANHMUC, NGUOIQUANLY, GHICHU FROM DANHMUC";
        try (Connection conn = dbutil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new DanhMuc(
                        rs.getInt("MADM"),
                        rs.getString("TENDANHMUC"),
                        rs.getString("NGUOIQUANLY"),
                        rs.getString("GHICHU")
                ));
            }
        } catch (SQLException ex) { throw new RuntimeException(ex); }
        return list;
    }

    public DanhMuc findById(int id) {
        String sql = "SELECT MADM, TENDANHMUC, NGUOIQUANLY, GHICHU FROM DANHMUC WHERE MADM=?";
        try (Connection conn = dbutil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new DanhMuc(rs.getInt("MADM"), rs.getString("TENDANHMUC"),
                            rs.getString("NGUOIQUANLY"), rs.getString("GHICHU"));
                }
            }
        } catch (SQLException ex) { throw new RuntimeException(ex); }
        return null;
    }
}
