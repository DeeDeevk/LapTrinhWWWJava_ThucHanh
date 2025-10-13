package fit.iuh.nguyenhovietkhoa_tuan7.repositories;

import fit.iuh.nguyenhovietkhoa_tuan7.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findProductByCategoryId(int categoryId);
    List<Product> findProductByCategoryName(String categoryName);
}
