package by.brandwatch.orderssevice.service.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Set;

@AllArgsConstructor
@Data
public class OrderDto {
    private Long id;
    private String nameOfCustomer;
    private String customerPhoneNumber;
    private Set<Long> productIds;
    private boolean isCompleted;
}
