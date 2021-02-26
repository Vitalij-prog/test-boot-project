package org.vital.bootproject.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.vital.bootproject.model.Order;
import org.vital.bootproject.model.OrderStatus;
import org.vital.bootproject.utils.Constants;

import java.util.List;

@Slf4j
@Component
@Aspect
public class ChangeOrderAmountAspect {

    @AfterReturning(value = "org.vital.bootproject.aop.Pointcuts.getOrdersList()", returning = "orderList")
    public List<Order> updateOrderAmount(List<Order> orderList) {

        Logger logger = LoggerFactory.getLogger("OrderLogger");

        logger.info("got orderList");

       for(Order order: orderList) {
           if(order.getOrderStatus() == OrderStatus.IN_DELIVERY) {
               order.setAmount(order.getAmount().add(Constants.DELIVERY_COST));

           }
           logger.info("order: " + order);
       }
       return orderList;
    }
}
