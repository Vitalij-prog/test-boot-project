package org.vital.bootproject.mapper;

import org.vital.bootproject.model.OrderStatus;

import java.sql.Date;

public class OrderResponse {
    private Date date;
    private OrderStatus orderStatus;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
