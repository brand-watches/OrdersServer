package by.brandwatch.orderssevice.service.order;

import by.brandwatch.orderssevice.exception.EntitiesNotFoundByIdsException;
import by.brandwatch.orderssevice.service.order.model.OrderDto;
import by.brandwatch.orderssevice.service.order.model.OrderSearchDto;
import by.brandwatch.orderssevice.service.order.model.OrderViewDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

public interface IOrderService {
    OrderViewDto getOrder(Long id) throws EntitiesNotFoundByIdsException;
    List<OrderViewDto> getOrders(Set<Long> ids) throws EntitiesNotFoundByIdsException;
    OrderViewDto createOrder(OrderDto orderDto);
    OrderViewDto updateOrder(Long id, OrderDto orderDto);

    Page<OrderViewDto> searchOrders(OrderSearchDto orderSearchDto);

}
