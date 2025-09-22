package fit.iuh.nguyenhovietkhoa_tuan5.servlet;

import fit.iuh.nguyenhovietkhoa_tuan5.dao.DepartmentDAO;
import fit.iuh.nguyenhovietkhoa_tuan5.dao.EmployeeDAO;
import fit.iuh.nguyenhovietkhoa_tuan5.model.Employee;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {
    @Resource(name = "jdbc/employeedb")
    private DataSource dataSource;
    private DepartmentDAO deptDao;

    private EmployeeDAO empDao;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        try {
            empDao = new EmployeeDAO(dataSource);
            deptDao = new DepartmentDAO(dataSource);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list";
        switch (action) {
            case "list":
                // Load toàn bộ employees (không quan tâm deptId)
                List<Employee> allEmployees = empDao.getAllEmployee();
                req.setAttribute("employees", allEmployees);
                req.getRequestDispatcher("employee-list.jsp").forward(req, resp);
                break;

            case "new":
                   req.setAttribute("departments", deptDao.getAllDepartments());
                req.getRequestDispatcher("employee-form.jsp").forward(req, resp);
                break;
            case "edit":
                int id = Integer.parseInt(req.getParameter("id"));
                // TODO: thêm method getById cho EmployeeDAO nếu muốn edit cụ thể
                break;
            case "delete":
                empDao.delete(Integer.parseInt(req.getParameter("id")));
                resp.sendRedirect("employees");
                break;
            case "viewbyid": // list all employees (or by department)
                String deptId = req.getParameter("deptId");
                List<Employee> list;

                if (deptId != null) {
                    list = empDao.getAllByDepartment(Integer.parseInt(deptId));
                } else {
                    list = empDao.getAllByDepartment(1); // mặc định dept 1
                }
                req.setAttribute("employees", list);
//                    req.setAttribute("departments", deptDao.getAll());
                req.getRequestDispatcher("employee-list.jsp").forward(req, resp);
        }
    }
}
