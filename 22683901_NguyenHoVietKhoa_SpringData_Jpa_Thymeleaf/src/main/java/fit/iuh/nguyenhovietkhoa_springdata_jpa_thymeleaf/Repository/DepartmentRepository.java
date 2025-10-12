package fit.iuh.nguyenhovietkhoa_springdata_jpa_thymeleaf.Repository;

import fit.iuh.nguyenhovietkhoa_springdata_jpa_thymeleaf.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Override
    List<Department> findAll();
}
