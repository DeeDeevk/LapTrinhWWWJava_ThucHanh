package fit.iuh.nguyenhovietkhoa_springdata_jpa_thymeleaf.Service;

import fit.iuh.nguyenhovietkhoa_springdata_jpa_thymeleaf.Model.Employee;
import fit.iuh.nguyenhovietkhoa_springdata_jpa_thymeleaf.Repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EmployeeService {
    EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }
    public boolean deleteById(Long id){
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id); // dùng method mặc định (void)
            return true;
        }
        return false;
    }
    public List<Employee> getEmployeesByAge(int age){
        return employeeRepository.findByAge(age);
    }
    public List<Employee> getEmployeesByName(String name){
        return employeeRepository.findByNameContaining(name);
    }

    public List<Employee> getEmployeesBySalary(double salary){
        return employeeRepository.findBySalaryGreaterThan(salary);
    }
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }


}
