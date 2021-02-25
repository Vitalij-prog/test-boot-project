package org.vital.bootproject.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.vital.bootproject.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
}
