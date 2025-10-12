package fit.iuh.nguyenhovietkhoa_springdata_jpa_thymeleaf.Controller;

import fit.iuh.nguyenhovietkhoa_springdata_jpa_thymeleaf.Model.Department;
import fit.iuh.nguyenhovietkhoa_springdata_jpa_thymeleaf.Model.Employee;
import fit.iuh.nguyenhovietkhoa_springdata_jpa_thymeleaf.Service.DepartmentService;
import fit.iuh.nguyenhovietkhoa_springdata_jpa_thymeleaf.Service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    EmployeeService employeeService;
    DepartmentService departmentService;
    public EmployeeController(EmployeeService employeeService , DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @PostMapping
    public String save(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        List<Department> departments = departmentService.getAllDepartment();
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departments);
        return "employee-form";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        employeeService.deleteById(id);
        return "redirect:/employees";
    }

    @GetMapping("/finding/name")
    public String findByName(@RequestParam String name, Model model){
        List<Employee> employees = employeeService.getEmployeesByName(name);
        model.addAttribute("employees", employees);
        return "employee-list";
    }

    @GetMapping("/finding/age")
    public String findByAge(@RequestParam int age, Model model){
        List<Employee> employees = employeeService.getEmployeesByAge(age);
        model.addAttribute("employees", employees);
        return "employee-list";
    }

    @GetMapping("/finding/salary")
    public String findBySalary(@RequestParam double salary, Model model){
        List<Employee> employees = employeeService.getEmployeesBySalary(salary);
        model.addAttribute("employees", employees);
        return "employee-list";
    }

    @GetMapping
    public String getAllEmployees(Model model){
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employee-list";
    }

}
