package fit.iuh.nguyenhovietkhoa_tuan5.dao;

import fit.iuh.nguyenhovietkhoa_tuan5.model.Department;
import fit.iuh.nguyenhovietkhoa_tuan5.model.Employee;
import fit.iuh.nguyenhovietkhoa_tuan5.util.DBUtil;
import org.eclipse.tags.shaded.org.apache.regexp.RE;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private DBUtil dbUtil;

    public EmployeeDAO(DataSource dataSource){
        dbUtil = new DBUtil(dataSource);
    }

    public List<Employee> getAllEmployee(){
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try {
            Connection conn = dbUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                int department_id = rs.getInt("department_id");
                Department d = new Department(department_id);
                Employee emp = new Employee(id, name, d, salary);
                employees.add(emp);
                return employees;
            }
            return employees;
            
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Employee> getAllByDepartment(int depId){
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees WHERE department_id = ?";
        try(Connection conn = dbUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ){
            stmt.setInt(1, depId);
            try {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()){
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    double salary = rs.getDouble("salary");
                    int department_id = rs.getInt("department_id");
                    Department d = new Department(department_id);
                    Employee emp = new Employee(id, name, d, salary);
                    employees.add(emp);
                }
                return employees;
            }catch (Exception e) {
                e.printStackTrace();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void save(Employee employee){
        String sql = "INSERT INTO employees(name, salary, department_id) VALUES (?,?,?)";
        try(Connection conn = dbUtil.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)
        ){
            statement.setString(1, employee.getName());
            statement.setDouble(2, employee.getSalary());
            statement.setInt(3, employee.getDepartment().getId());
            statement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Employee employee){
        String sql = "UPDATE employees SET name=?, salary=?, department_id=? WHERE id=?";
        try(Connection conn = dbUtil.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)
        ){
            statement.setString(1, employee.getName());
            statement.setDouble(2, employee.getSalary());
            statement.setInt(3, employee.getDepartment().getId());
            statement.setInt(4, employee.getId());
            statement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id){
        String sql = "DELETE FROM employees WHERE id=?";
        try(Connection conn = dbUtil.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)
        ){
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
