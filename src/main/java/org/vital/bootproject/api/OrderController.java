package org.vital.bootproject.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.vital.bootproject.mapper.OrderResponse;
import org.vital.bootproject.model.Order;
import org.vital.bootproject.model.OrderStatus;
import org.vital.bootproject.service.OrderService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService service;



    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }


    @PostMapping()
    public void addOrder(/*@RequestBody Order order*/) {
       /* service.addOrder(order);*/

        Order order = new Order();
        order.setAmount(123);
        order.setDate(new java.sql.Date(new java.util.Date().getTime()));
        order.setDescription("smth description");
        order.setOrderStatus(OrderStatus.ACCEPTED);
        service.addOrder(order);
    }

    @GetMapping()
    public List<Order> getAllOrders() {
        return service.getAllOrders();
    }

    @GetMapping("/user/{id}/orders")
    public List<Order> getAllOrdersByUserId(@PathVariable int id) {
        return service.getOrdersListByUserId(id);
    }


    @GetMapping(path = "{id}")
    public OrderResponse getOrderById(@PathVariable int id) {
        return service.getOrderById(id);
    }

}
