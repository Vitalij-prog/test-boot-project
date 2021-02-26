package org.vital.bootproject.mapper;

import org.vital.bootproject.dao.OrderRepository;
import org.vital.bootproject.model.Order;

public class OrderResponseMapper {

    public static OrderResponse toOrderResponse(Order order) {
        OrderResponse response = new OrderResponse();

        response.setDate(order.getDate());
        response.setOrderStatus(order.getOrderStatus());

        return response;
    }
}
