package com.lin.nosql;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lin.nosql.cache.OrderDao;
import com.lin.nosql.dao.OrderRepository;
import com.lin.nosql.domain.Item;
import com.lin.nosql.domain.Order;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;



@RunWith(SpringRunner.class)
@SpringBootTest
public class NoSqlApplicationTests {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDao orderDao;

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Before
    public void setUp() {
        mongoTemplate.createCollection(Order.class);
    }

    @After
    public void tearDown() {
        mongoTemplate.dropCollection(Order.class);
    }

    @Test
    public void insertTestAndFind() {
        Order order = new Order();

        List<Item> list = new ArrayList<>();
        Item item = new Item();
        item.setPrice(1);
        item.setProduct("testProduct");
        item.setQuantity(1);
        list.add(item);

        order.setCustomer("testCustomer");
        order.setType("testType");
        order.setItems(list);
        orderRepository.insert(order);

        Order order2 = orderRepository.findByCustomer("testCustomer");
        Assert.assertEquals(order.getCustomer(), order2.getCustomer());
    }

    @Test
    public void cacheTest() {
        Order order = orderDao.find(1L);
        System.out.println(order.getId());
        System.out.println("--------------");
        order = orderDao.find(1L);
        System.out.println(order.getId());
    }

    @Test
    public void cachePutTest() {
        Order order = new Order();
        order.setId("3");
        orderDao.save(order);
        order = orderDao.find(3L);
        System.out.println("order:" + order.getId());
    }

    @Test
    public void cacheRemoveTest() {
        orderDao.find(3L);
        System.out.println("-----删除缓存---------------");
        orderDao.remove(3L);
        orderDao.find(3L);
    }


}
