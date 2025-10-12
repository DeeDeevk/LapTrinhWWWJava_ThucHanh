package fit.iuh.nguyenhovietkhoa_springdata_jpa_thymeleaf.Service;

import fit.iuh.nguyenhovietkhoa_springdata_jpa_thymeleaf.Model.Department;
import fit.iuh.nguyenhovietkhoa_springdata_jpa_thymeleaf.Repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DepartmentService {
    DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }
}
