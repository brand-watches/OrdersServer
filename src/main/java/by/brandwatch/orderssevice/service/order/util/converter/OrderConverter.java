package by.brandwatch.orderssevice.service.order.util.converter;

import by.brandwatch.orderssevice.repository.order.OrderEntity;
import by.brandwatch.orderssevice.repository.product.ProductEntity;
import by.brandwatch.orderssevice.service.order.model.OrderViewDto;
import by.brandwatch.orderssevice.service.product.model.ProductViewDto;
import by.brandwatch.orderssevice.service.product.util.converter.ProductConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderConverter {

    private final ProductConverter productConverter;

    @Autowired
    public OrderConverter(ProductConverter productConverter) {
        this.productConverter = productConverter;
    }

    public List<OrderViewDto> convertToDto(List<OrderEntity> entities) {
        return entities.stream().map(this::convertToViewDto).toList();
    }

    public List<OrderEntity> convertToEntity(List<OrderViewDto> dtos) {
        return dtos.stream().map(this::convertToEntity).toList();
    }

    public OrderViewDto convertToViewDto(OrderEntity entity) {
        List<ProductViewDto> productViewDtos = new ArrayList<>(entity.getProduct().stream().map(productConverter::convertToViewDTO).toList());
        return new OrderViewDto(
                entity.getId(),
                entity.getNameOfCustomer(),
                entity.getCustomerPhoneNumber(),
                productViewDtos,
                entity.getOrderDate(),
                entity.isCompleted()
        );
    }

    public OrderEntity convertToEntity(OrderViewDto dto) {
        List<ProductEntity> productEntities = new ArrayList<>(dto.getProduct().stream().map(productConverter::convertToEntity).toList());
        return new OrderEntity(
                dto.getId(),
                dto.getNameOfCustomer(),
                dto.getCustomerPhoneNumber(),
                dto.getOrderDate(),
                productEntities,
                dto.isCompleted()
        );
    }
}
