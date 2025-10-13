package fit.iuh.nguyenhovietkhoa_tuan7.controller;

import fit.iuh.nguyenhovietkhoa_tuan7.entities.Order;
import fit.iuh.nguyenhovietkhoa_tuan7.services.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String showAllOrders(Model model) {
        List<Order> orderList = orderService.findAllOrders();
        model.addAttribute("orders", orderList);
        return "order/list";
    }

    @GetMapping("/{id}")
    public String showOrder(@PathVariable int id, Model model) {
        Order order = orderService.findById(id);
        model.addAttribute("order", order);
        return "order/orderDetail";
    }
}
