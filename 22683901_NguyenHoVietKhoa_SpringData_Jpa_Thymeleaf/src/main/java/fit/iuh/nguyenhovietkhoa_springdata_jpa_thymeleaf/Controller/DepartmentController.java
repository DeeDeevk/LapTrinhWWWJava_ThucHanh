package fit.iuh.nguyenhovietkhoa_springdata_jpa_thymeleaf.Controller;

import fit.iuh.nguyenhovietkhoa_springdata_jpa_thymeleaf.Model.Department;
import fit.iuh.nguyenhovietkhoa_springdata_jpa_thymeleaf.Service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentController {
    DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public String getAllDepartments(Model model){
        List<Department> departments = departmentService.getAllDepartment();
        model.addAttribute("departments", departments);
        return "department-list";
    }

}
