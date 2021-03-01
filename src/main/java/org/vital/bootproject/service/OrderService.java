package org.vital.bootproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.vital.bootproject.dao.OrderRepository;
import org.vital.bootproject.dao.UserRepository;
import org.vital.bootproject.exceptions.OrderNotFoundException;
import org.vital.bootproject.mapper.OrderListRequest;
import org.vital.bootproject.mapper.OrderResponse;
import org.vital.bootproject.mapper.OrderResponseMapper;
import org.vital.bootproject.model.Order;
import org.vital.bootproject.model.User;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OrderService  {

    private final OrderRepository orderRepository;

    @Autowired
    @Qualifier("users_db")
    private UserRepository userRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void addOrder(Order order) {

        Optional<User> user = userRepository.findById(1);

        user.get().addOrder(order);

        orderRepository.save(order);
    }

    public List<Order> getAllOrders() {

       /* return (List<Order>) orderRepository.findAll();*/

        List<Order> list = (List<Order>) orderRepository.findAll();
        for(Order order : list) {
            System.out.println(order);
        }

        return list;
    }

    public OrderResponse getOrderById(int id) throws OrderNotFoundException {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if(optionalOrder.isPresent()) {
            return OrderResponseMapper.toOrderResponse(optionalOrder.get());
        }
        throw new OrderNotFoundException("Order with id = " + id + " not found");
    }


    public List<Order> getOrdersListByUserId(int id) {
        User user = new User();
        user.setId(id);
        Pageable pageable = PageRequest.of(0,4, Sort.by("amount"));
        return orderRepository.getOrdersListByUserId(id, pageable);
    }

    public Page<Order> getOrdersPage(OrderListRequest request) {
        User user = new User();
        user.setId(request.getId());
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());
        return orderRepository.findByUser(user, pageable);
    }

}
