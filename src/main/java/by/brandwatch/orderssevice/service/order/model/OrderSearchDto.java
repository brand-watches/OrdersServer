package by.brandwatch.orderssevice.service.order.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderSearchDto {
    private String id = "";
    private String sortBy = "orderDate";
    private String sortOrder = "desc";
    private int page = 0;
    private int size = 10;
}
