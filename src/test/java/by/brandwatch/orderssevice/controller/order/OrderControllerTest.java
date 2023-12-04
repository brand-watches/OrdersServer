package by.brandwatch.orderssevice.controller.order;

import by.brandwatch.orderssevice.mock.MockDto;
import by.brandwatch.orderssevice.service.order.impl.OrderService;
import by.brandwatch.orderssevice.service.order.model.OrderDto;
import by.brandwatch.orderssevice.service.order.model.OrderSearchDto;
import by.brandwatch.orderssevice.service.order.model.OrderViewDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class OrderControllerTest {

    @InjectMocks
    private OrderController orderController;

    @Mock
    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetOrder() {
        Long orderId = 1L;
        OrderViewDto orderViewDto = MockDto.createOrderViewDto();

        when(orderService.getOrder(orderId)).thenReturn(orderViewDto);

        ResponseEntity<OrderViewDto> responseEntity = orderController.getOrder(orderId);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(orderViewDto, responseEntity.getBody());
    }

    @Test
    public void testGetOrders() {
        OrderSearchDto orderSearchDto = new OrderSearchDto();
        Page<OrderViewDto> orderViewPage = new PageImpl<>(List.of(MockDto.createOrderViewDto()));

        when(orderService.searchOrders(orderSearchDto)).thenReturn(orderViewPage);

        ResponseEntity<Page<OrderViewDto>> responseEntity = orderController.getOrders(orderSearchDto);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(orderViewPage, responseEntity.getBody());
    }

    @Test
    public void testCreateOrder() {
        OrderDto orderDto = MockDto.createOrderDto();
        OrderViewDto orderViewDto = MockDto.createOrderViewDto();

        when(orderService.createOrder(orderDto)).thenReturn(orderViewDto);

        ResponseEntity<OrderViewDto> responseEntity = orderController.createOrder(orderDto);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(orderViewDto, responseEntity.getBody());
    }

    @Test
    public void testUpdateOrder() {
        Long orderId = 1L;
        OrderDto orderDto = MockDto.createOrderDto();
        OrderViewDto orderViewDto = MockDto.createOrderViewDto();

        when(orderService.updateOrder(orderId, orderDto)).thenReturn(orderViewDto);

        ResponseEntity<OrderViewDto> responseEntity = orderController.updateOrder(orderId, orderDto);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(orderViewDto, responseEntity.getBody());
    }

}
