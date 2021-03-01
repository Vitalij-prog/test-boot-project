package org.vital.bootproject.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;


import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.vital.bootproject.model.Order;
import org.vital.bootproject.model.OrderStatus;
import org.vital.bootproject.utils.Constants;

import java.util.List;

@Slf4j
@Component
@Aspect
public class ChangeOrderAmountAspect {

    @Pointcut("execution(java.util.List<org.vital.bootproject.model.Order> org.vital.bootproject.service.OrderService.getOrdersList*(int))")
    public void getOrdersList(){}

    @Pointcut("execution(org.springframework.data.domain.Page<org.vital.bootproject.model.Order> org.vital.bootproject.service.OrderService.getOrdersPage*(..))")
    public void getOrdersPage(){

    }
    @AfterReturning(value = "getOrdersPage()", returning = "ordersPage")
    public Page<Order> updateOrderAmount(Page<Order> ordersPage) {

        Logger logger = LoggerFactory.getLogger("OrderLogger");

        logger.info("got orderList");

       for(Order order: ordersPage) {
           if(order.getOrderStatus() == OrderStatus.IN_DELIVERY) {
               order.setAmount(order.getAmount().add(Constants.DELIVERY_COST));
           }
           logger.info("order: " + order);
       }
       return ordersPage;
    }
}
