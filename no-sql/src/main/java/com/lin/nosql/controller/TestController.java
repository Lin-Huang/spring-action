package com.lin.nosql.controller;

import com.lin.nosql.domain.Order;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order test() {
        System.out.println("test");
        return new Order();
    }

    @PostMapping(value = "/test2", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Order test2() {
        System.out.println("test2");
        return new Order();
    }
}
