package com.lin.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @JmsListener(destination = "test")
    public void receive(String text) {
        System.out.println("receive :" + text);
    }
}
