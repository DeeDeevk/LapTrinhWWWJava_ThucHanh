package iuh.fit.nguyenhovietkhoa_tuan5_bai6.dao;

import iuh.fit.nguyenhovietkhoa_tuan5_bai6.model.TinTuc;
import iuh.fit.nguyenhovietkhoa_tuan5_bai6.util.DBUtil;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TinTucDAO {
    private DBUtil dbutil;

    public TinTucDAO(DataSource ds) {
        this.dbutil = new DBUtil(ds);
    }
    public List<TinTuc> findByDanhMuc(int madm) {
        List<TinTuc> list = new ArrayList<>();
        String sql = "SELECT MATT, TIEUDE, NOIDUNGTT, LIENKET, MADM FROM TINTUC WHERE MADM = ?";
        try (Connection conn = dbutil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, madm);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new TinTuc(rs.getInt("MATT"),
                            rs.getString("TIEUDE"),
                            rs.getString("NOIDUNGTT"),
                            rs.getString("LIENKET"),
                            rs.getInt("MADM")));
                }
            }
        } catch (SQLException ex) { throw new RuntimeException(ex); }
        return list;
    }
    // thêm mới tin tức
    public void insert(TinTuc tin) {
        String sql = "INSERT INTO TINTUC(TIEUDE, NOIDUNGTT, LIENKET, MADM) VALUES (?,?,?,?)";
        try (Connection conn = dbutil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tin.getTieuDe());
            ps.setString(2, tin.getNoiDung());
            ps.setString(3, tin.getLienKet());
            ps.setInt(4, tin.getMadm());
            ps.executeUpdate();
        } catch (SQLException ex) { throw new RuntimeException(ex); }
    }
    // xóa tin tức theo MATT
    public void delete(int matt) {
        String sql = "DELETE FROM TINTUC WHERE MATT = ?";
        try (Connection conn = dbutil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, matt);
            ps.executeUpdate();
        } catch (SQLException ex) { throw new RuntimeException(ex); }
    }
}
