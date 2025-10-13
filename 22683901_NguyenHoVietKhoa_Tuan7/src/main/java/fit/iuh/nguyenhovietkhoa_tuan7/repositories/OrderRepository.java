package fit.iuh.nguyenhovietkhoa_tuan7.repositories;

import fit.iuh.nguyenhovietkhoa_tuan7.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
