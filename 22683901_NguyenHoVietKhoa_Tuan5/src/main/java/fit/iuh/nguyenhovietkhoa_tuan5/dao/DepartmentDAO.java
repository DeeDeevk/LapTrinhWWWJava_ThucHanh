package fit.iuh.nguyenhovietkhoa_tuan5.dao;

import fit.iuh.nguyenhovietkhoa_tuan5.model.Department;
import fit.iuh.nguyenhovietkhoa_tuan5.util.DBUtil;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
    private DBUtil ubUtil;

    public DepartmentDAO(DataSource dataSource){
        this.ubUtil = new DBUtil(dataSource);
    }



    // get all departments
    public List<Department> getAllDepartments(){
        List<Department> departments = new ArrayList<>();
        String sql = "SELECT * FROM departments";
        try (var connection = ubUtil.getConnection();
             var statement = connection.createStatement();
             var resultSet = statement.executeQuery(sql);
        ){
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Department department = new Department(id, name);
                departments.add(department);
            }
            return departments;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
