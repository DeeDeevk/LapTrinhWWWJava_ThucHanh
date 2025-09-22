package fit.iuh.nguyenhovietkhoa_tuan5.dao;

import fit.iuh.nguyenhovietkhoa_tuan5.util.DBUtil;

import javax.sql.DataSource;

public class DepartmentDAO {
    private DBUtil dbUtil;

    public DepartmentDAO(DataSource dataSource){
        dbUtil = new DBUtil(dataSource);
    }
}
