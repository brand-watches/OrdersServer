package by.brandwatch.orderssevice.service.order.impl;

import by.brandwatch.orderssevice.exception.EntitiesNotFoundByIdsException;
import by.brandwatch.orderssevice.repository.order.OrderEntity;
import by.brandwatch.orderssevice.repository.order.OrderRepository;
import by.brandwatch.orderssevice.repository.product.ProductEntity;
import by.brandwatch.orderssevice.repository.product.ProductRepository;
import by.brandwatch.orderssevice.service.order.IOrderService;
import by.brandwatch.orderssevice.service.order.model.OrderDto;
import by.brandwatch.orderssevice.service.order.model.OrderSearchDto;
import by.brandwatch.orderssevice.service.order.model.OrderViewDto;
import by.brandwatch.orderssevice.service.order.util.converter.OrderConverter;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Service class for managing order-related operations.
 */
@Service
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;
    private final OrderConverter orderConverter;
    private final ProductRepository productRepository;

    private final String ENTITY_NAME = "Заказы";

    @Autowired
    public OrderService(
            OrderRepository orderRepository,
            OrderConverter orderConverter,
            ProductRepository productRepository
    ) {
        this.orderRepository = orderRepository;
        this.orderConverter = orderConverter;
        this.productRepository = productRepository;
    }

    /**
     * Retrieves an order by its identifier.
     *
     * @param id The identifier of the order.
     * @return OrderViewDto representing the order.
     * @throws EntitiesNotFoundByIdsException If the order with the specified ID is not found.
     */
    public OrderViewDto getOrder(Long id) throws EntitiesNotFoundByIdsException {
        Optional<OrderEntity> orderEntity = this.orderRepository.findById(id);
        if (orderEntity.isPresent()) {
            return this.orderConverter.convertToViewDto(orderEntity.get());
        } else {
            throw new EntitiesNotFoundByIdsException(List.of(id), this.ENTITY_NAME);
        }
    }

    /**
     * Retrieves orders by their identifiers.
     *
     * @param ids Set of order identifiers.
     * @return List of OrderViewDto representing the orders.
     * @throws EntitiesNotFoundByIdsException If any of the specified orders are not found.
     */
    public List<OrderViewDto> getOrders(Set<Long> ids) throws EntitiesNotFoundByIdsException {
        if (this.orderRepository.existsAllByIdIn(ids)) {
            return this.orderConverter.convertToDto(this.orderRepository.findAllByIdIn(ids));
        } else {
            throw new EntitiesNotFoundByIdsException(ids.stream().toList(), this.ENTITY_NAME);
        }
    }

    /**
     * Creates a new order.
     *
     * @param orderDto Information about the new order in the form of OrderDto.
     * @return OrderViewDto representing the created order.
     */
    @Transactional
    public OrderViewDto createOrder(OrderDto orderDto) {
        OrderEntity orderEntity = this.getOrderEntity(orderDto, this.getLocalTime(), false);
        OrderEntity savedOrderEntity = this.orderRepository.save(orderEntity);
        return this.orderConverter.convertToViewDto(savedOrderEntity);
    }

    /**
     * Updates information about an existing order.
     *
     * @param id      Identifier of the order to be updated.
     * @param orderDto Information about the order in the form of OrderDto.
     * @return OrderViewDto representing the updated order.
     * @throws EntitiesNotFoundByIdsException If the order with the specified ID is not found.
     */
    @Transactional
    public OrderViewDto updateOrder(Long id, OrderDto orderDto) {
        Optional<OrderEntity> existsOrderEntity = this.orderRepository.findById(id);
        if (existsOrderEntity.isEmpty()) {
            throw new EntitiesNotFoundByIdsException(List.of(id), this.ENTITY_NAME);
        } else {
            OrderEntity orderEntity = this.getOrderEntity(orderDto, existsOrderEntity.get().getOrderDate(), existsOrderEntity.get().isCompleted());
            orderEntity.setId(id);
            OrderEntity savedOrderEntity = this.orderRepository.save(orderEntity);
            return this.orderConverter.convertToViewDto(savedOrderEntity);
        }
    }

    /**
     * Searches for orders based on the provided criteria.
     *
     * @param orderSearchDto The criteria for searching orders.
     * @return Page of OrderViewDto representing the search results.
     */
    @Override
    public Page<OrderViewDto> searchOrders(OrderSearchDto orderSearchDto) {
        Pageable pageable;
        if (orderSearchDto.getSortOrder().equals("asc")) {
            pageable = PageRequest.of(orderSearchDto.getPage(), orderSearchDto.getSize(), Sort.by(orderSearchDto.getSortBy()).ascending());
        } else {
            pageable = PageRequest.of(orderSearchDto.getPage(), orderSearchDto.getSize(), Sort.by(orderSearchDto.getSortBy()).descending());
        }
        Page<OrderEntity> orderEntities;

        if (orderSearchDto.getId() != null) {
            Specification<OrderEntity> idPartialSpec = (root, query, criteriaBuilder) -> {
                String partialId = "%" + orderSearchDto.getId() + "%";
                return criteriaBuilder.like(root.get("id").as(String.class), partialId);
            };

            orderEntities = this.orderRepository.findAll(idPartialSpec, pageable);
        } else {
            orderEntities = this.orderRepository.findBy(pageable);
        }
        return orderEntities.map(this.orderConverter::convertToViewDto);
    }

    private OrderEntity getOrderEntity(OrderDto orderDto, String orderDateTime, boolean isCompleted) {
        List<ProductEntity> productEntities = new ArrayList<>(productRepository.findAllByIdIn(orderDto.getProductIds()));
        return new OrderEntity(
                orderDto.getId(),
                orderDto.getNameOfCustomer(),
                orderDto.getCustomerPhoneNumber(),
                orderDateTime,
                productEntities,
                isCompleted
        );
    }

    private String getLocalTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
}
