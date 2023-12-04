package by.brandwatch.orderssevice.controller.order;

import by.brandwatch.orderssevice.exception.EntitiesNotFoundByIdsException;
import by.brandwatch.orderssevice.service.order.IOrderService;
import by.brandwatch.orderssevice.service.order.model.OrderDto;
import by.brandwatch.orderssevice.service.order.model.OrderSearchDto;
import by.brandwatch.orderssevice.service.order.model.OrderViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

/**
 * Controller class for managing order-related operations.
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final IOrderService orderService;

    @Autowired
    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Retrieves an order by its identifier.
     *
     * @param id The identifier of the order.
     * @return OrderViewDto representing the order.
     * @throws EntitiesNotFoundByIdsException If the order with the specified ID is not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<OrderViewDto> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrder(id));
    }

    /**
     * Searches for orders based on the provided criteria.
     *
     * @param orderSearchDto The criteria for searching orders.
     * @return Page of OrderViewDto representing the search results.
     * @throws EntitiesNotFoundByIdsException If no orders match the specified criteria.
     */
    @PostMapping("/search")
    public ResponseEntity<Page<OrderViewDto>> getOrders(@RequestBody OrderSearchDto orderSearchDto) {
        return ResponseEntity.ok(orderService.searchOrders(orderSearchDto));
    }

    /**
     * Creates a new order.
     *
     * @param orderDto Information about the new order in the form of OrderDto.
     * @return OrderViewDto representing the created order.
     */
    @PostMapping("")
    public ResponseEntity<OrderViewDto> createOrder(@RequestBody OrderDto orderDto) {
        return ResponseEntity.ok(this.orderService.createOrder(orderDto));
    }

    /**
     * Updates information about an existing order.
     *
     * @param id       Identifier of the order to be updated.
     * @param orderDto Information about the order in the form of OrderDto.
     * @return OrderViewDto representing the updated order.
     */
    @PutMapping("/{id}")
    public ResponseEntity<OrderViewDto> updateOrder(@PathVariable("id") Long id, @RequestBody OrderDto orderDto) {
        return ResponseEntity.ok(this.orderService.updateOrder(id, orderDto));
    }
}
