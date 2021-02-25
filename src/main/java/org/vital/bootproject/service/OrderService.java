package org.vital.bootproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.vital.bootproject.dao.OrderRepository;
import org.vital.bootproject.dao.UserRepository;
import org.vital.bootproject.model.Order;
import org.vital.bootproject.model.User;

import java.util.List;
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
}
