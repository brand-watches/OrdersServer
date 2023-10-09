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

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final IOrderService orderService;

    @Autowired
    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderViewDto> getOrder(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(orderService.getOrder(id));
        } catch (EntitiesNotFoundByIdsException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getMessage(), e);
        }
    }

    @PostMapping("/search")
    public ResponseEntity<Page<OrderViewDto>> getOrders(@RequestBody OrderSearchDto orderSearchDto) {
        try {
            return ResponseEntity.ok(orderService.searchOrders(orderSearchDto));
        } catch (EntitiesNotFoundByIdsException e) {
            throw new ResponseStatusException(e.getStatusCode(), e.getMessage(), e);
        }
    }

    @PostMapping("")
    public ResponseEntity<OrderViewDto> createOrder(@RequestBody OrderDto orderDto) {
        return ResponseEntity.ok(this.orderService.createOrder(orderDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderViewDto> updateOrder(@PathVariable("id") Long id, @RequestBody OrderDto orderDto) {
        return ResponseEntity.ok(this.orderService.updateOrder(id, orderDto));
    }
}
