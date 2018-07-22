package com.lin.rest.controller;

import com.lin.rest.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public User test() {
        System.out.println("test");
        return new User();
    }

    @PostMapping(value = "/test2", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User test2() {
        System.out.println("test2");
        return new User();
    }
}
