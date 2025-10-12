package fit.iuh.nguyenhovietkhoa_springdata_jpa_thymeleaf.Repository;

import fit.iuh.nguyenhovietkhoa_springdata_jpa_thymeleaf.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    boolean deleteById(int id);

    @Override
    List<Employee> findAll();

    List<Employee> findByAge(int age);
    List<Employee> findByNameContaining(String name);
    List<Employee> findBySalaryGreaterThan(double salary);
}
