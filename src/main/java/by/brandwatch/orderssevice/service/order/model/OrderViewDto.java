package by.brandwatch.orderssevice.service.order.model;

import by.brandwatch.orderssevice.service.product.model.ProductViewDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class OrderViewDto {
    private Long id;
    private String nameOfCustomer;
    private String customerPhoneNumber;
    private List<ProductViewDto> product;
    private String orderDate;
    private boolean isCompleted;
}
