package org.vital.bootproject.aop;


import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {
    @Pointcut("execution(java.util.List<org.vital.bootproject.model.Order> org.vital.bootproject.service.OrderService.getOrdersList*(int))")
    public void getOrdersList(){}
}
