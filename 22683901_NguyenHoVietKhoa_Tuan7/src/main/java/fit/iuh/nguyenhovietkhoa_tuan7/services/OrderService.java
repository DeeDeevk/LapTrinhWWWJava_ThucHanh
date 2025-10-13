package fit.iuh.nguyenhovietkhoa_tuan7.services;

import fit.iuh.nguyenhovietkhoa_tuan7.entities.Order;
import fit.iuh.nguyenhovietkhoa_tuan7.repositories.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional(readOnly = true)
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Order findById(int id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Hóa đơn: " + id));

        order.getOrderlines().size();

        return order;
    }
}
