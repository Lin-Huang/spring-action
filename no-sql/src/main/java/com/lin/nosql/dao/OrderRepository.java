package com.lin.nosql.dao;

import com.lin.nosql.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
    Order findByCustomer(String customer);
}
