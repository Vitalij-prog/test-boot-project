package org.vital.bootproject.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import org.vital.bootproject.mapper.OrderListRequest;
import org.vital.bootproject.mapper.OrderResponse;
import org.vital.bootproject.model.Order;
import org.vital.bootproject.model.OrderStatus;
import org.vital.bootproject.service.OrderService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }


    @PostMapping
    public void addOrder(/*@RequestBody Order order*/) {
       /* service.addOrder(order);*/

        Order order = new Order();
        order.setAmount(new BigDecimal(123));
        order.setDate(new java.sql.Date(new java.util.Date().getTime()));
        order.setDescription("smth description");
        order.setOrderStatus(OrderStatus.ACCEPTED);
        service.addOrder(order);
    }

    @GetMapping("find")
    public List<Order> getAllOrders() {
        return service.getAllOrders();
    }

    @GetMapping
    public List<Order> getAllOrdersByUserId(@RequestParam("userId") int id) {
        return service.getOrdersListByUserId(id);
    }

    @PostMapping("byUserId")
    public Page<Order> getOrdersPageByUserId(@RequestBody OrderListRequest request) {
        return service.getOrdersPage(request);
    }

    @GetMapping("{id}")
    public OrderResponse getOrderById(@PathVariable int id) {
        return service.getOrderById(id);
    }

}
