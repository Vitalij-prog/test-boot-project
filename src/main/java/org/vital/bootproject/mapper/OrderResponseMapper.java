package org.vital.bootproject.mapper;

import org.vital.bootproject.dao.OrderRepository;
import org.vital.bootproject.model.Order;

public class OrderResponseMapper {

    public static OrderResponse toOrderResponse(Order order) {

        return OrderResponse.builder()
                .date(order.getDate())
                .orderStatus(order.getOrderStatus())
                .build();
    }
}
