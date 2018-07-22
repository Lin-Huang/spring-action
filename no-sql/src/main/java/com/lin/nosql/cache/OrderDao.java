package com.lin.nosql.cache;

import com.lin.nosql.domain.Order;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {
    @Cacheable("orderCache")
    public Order find(Long id) {
        System.out.println("获取数据" + id);
        Order order = new Order();
        order.setId(id.toString());
        return order;
    }

    @CachePut(value = "orderCache", key = "#result.id")
    public Order save(Order order) {
        System.out.println("保存数据" + order.getId());
        return order;
    }

    @CacheEvict("orderCache")
    public void remove(Long id){
        System.out.println("删除数据");
    }
}
