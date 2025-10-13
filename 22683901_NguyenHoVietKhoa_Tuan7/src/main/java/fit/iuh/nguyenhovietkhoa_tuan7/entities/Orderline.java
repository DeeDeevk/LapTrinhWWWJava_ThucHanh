package fit.iuh.nguyenhovietkhoa_tuan7.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "orderlines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Orderline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int amount;
    private BigDecimal purchasePrice;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;
}
