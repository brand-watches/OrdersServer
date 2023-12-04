package by.brandwatch.orderssevice.repository.order;

import by.brandwatch.orderssevice.repository.product.ProductEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nameOfCustomer;

    @Column(nullable = false)
    private String customerPhoneNumber;

    @Column(nullable = false)
    private String orderDate;

    @Column(nullable = false)
    @ManyToMany(cascade = CascadeType.ALL)
    private List<ProductEntity> product;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private boolean isCompleted;

}
