package fit.iuh.nguyenhovietkhoa_tuan7.repositories;

import fit.iuh.nguyenhovietkhoa_tuan7.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByName(String name);
}
