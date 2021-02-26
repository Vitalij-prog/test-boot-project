package org.vital.bootproject.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.vital.bootproject.model.Order;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

    @Query("select o from Order o where o.user.id = ?1")
    List<Order> getOrdersListByUserId(int id);
}
