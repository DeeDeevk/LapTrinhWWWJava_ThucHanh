package fit.iuh.nguyenhovietkhoa_tuan7.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private Calendar date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Orderline> orderlines;

    public BigDecimal getTotalAmount() {
        if (orderlines == null) return BigDecimal.ZERO;
        return orderlines.stream()
                .map(line -> line.getPurchasePrice().multiply(new BigDecimal(line.getAmount())))
                // HOẶC
                // .map(line -> line.getPurchasePrice().multiply(BigDecimal.valueOf(line.getAmount().longValue()))) // Nếu amount là Integer
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
