package by.brandwatch.orderssevice.service.order.impl;

import by.brandwatch.orderssevice.mock.MockDto;
import by.brandwatch.orderssevice.mock.MockEntity;
import by.brandwatch.orderssevice.repository.order.OrderEntity;
import by.brandwatch.orderssevice.repository.order.OrderRepository;
import by.brandwatch.orderssevice.repository.product.ProductRepository;
import by.brandwatch.orderssevice.service.order.model.OrderDto;
import by.brandwatch.orderssevice.service.order.model.OrderSearchDto;
import by.brandwatch.orderssevice.service.order.model.OrderViewDto;
import by.brandwatch.orderssevice.service.order.util.converter.OrderConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrderConverter orderConverter;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetOrder() {
        Long orderId = 1L;
        OrderEntity orderEntity = MockEntity.createOrderEntity();
        OrderViewDto expectedOrderViewDto = MockDto.createOrderViewDto();

        when(orderRepository.findById(orderId)).thenReturn(Optional.of(orderEntity));
        when(orderConverter.convertToViewDto(orderEntity)).thenReturn(expectedOrderViewDto);

        OrderViewDto actualOrderViewDto = orderService.getOrder(orderId);

        assertNotNull(actualOrderViewDto);
        assertEquals(expectedOrderViewDto, actualOrderViewDto);
    }

    @Test
    public void testCreateOrder() {
        Long orderId = 1L;
        OrderDto orderDto = MockDto.createOrderDto();
        OrderEntity expectedOrderEntity = MockEntity.createOrderEntity();
        OrderEntity savedOrderEntity = MockEntity.createOrderEntity();
        OrderViewDto expectedOrderViewDto = MockDto.createOrderViewDto();

        when(productRepository.findAllByIdIn(orderDto.getProductIds())).thenReturn(new ArrayList<>());
        when(orderRepository.save(ArgumentMatchers.any())).thenReturn(savedOrderEntity);
        when(orderConverter.convertToViewDto(savedOrderEntity)).thenReturn(expectedOrderViewDto);
        when(productRepository.findAllByIdIn(Set.of(orderId))).thenReturn(MockEntity.createProductEntities());


        OrderViewDto actualOrderViewDto = orderService.createOrder(orderDto);

        assertNotNull(actualOrderViewDto);
        assertEquals(expectedOrderViewDto, actualOrderViewDto);
    }

    @Test
    public void testUpdateOrder() {
        Long orderId = 1L;
        OrderDto orderDto = MockDto.createOrderDto();
        OrderEntity existingOrderEntity = MockEntity.createOrderEntity();
        OrderEntity expectedOrderEntity = MockEntity.createOrderEntity();
        OrderEntity savedOrderEntity = MockEntity.createOrderEntity();
        OrderViewDto expectedOrderViewDto = MockDto.createOrderViewDto();

        when(orderRepository.findById(orderId)).thenReturn(Optional.of(existingOrderEntity));
        when(productRepository.findAllByIdIn(Set.of(orderId))).thenReturn(MockEntity.createProductEntities());
        when(orderRepository.save(expectedOrderEntity)).thenReturn(savedOrderEntity);
        when(orderConverter.convertToViewDto(savedOrderEntity)).thenReturn(expectedOrderViewDto);

        OrderViewDto actualOrderViewDto = orderService.updateOrder(orderId, orderDto);

        assertNotNull(actualOrderViewDto);
        assertEquals(expectedOrderViewDto, actualOrderViewDto);
    }

//    @Test
//    public void testSearchOrders() {
//        OrderSearchDto orderSearchDto = new OrderSearchDto();
//        OrderEntity orderEntity = MockEntity.createOrderEntity();
//        List<OrderEntity> orderEntities = Collections.singletonList(orderEntity);
//        OrderViewDto expectedOrderViewDto = MockDto.createOrderViewDto();
//        Page<OrderViewDto> expectedPage = new PageImpl<>(Collections.singletonList(expectedOrderViewDto));
//
//        when(orderSearchDto.getSortOrder()).thenReturn("desc");
//        when(orderSearchDto.getSortBy()).thenReturn("orderDate");
//        when(orderRepository.findAll(ArgumentMatchers.any(Specification.class), ArgumentMatchers.any(Pageable.class))).thenReturn(new PageImpl<>(orderEntities));
//        when(orderConverter.convertToViewDto(orderEntity)).thenReturn(expectedOrderViewDto);
//
//
//        Page<OrderViewDto> actualPage = orderService.searchOrders(orderSearchDto);
//
//        assertNotNull(actualPage);
//        assertEquals(expectedPage, actualPage);
//    }
}
