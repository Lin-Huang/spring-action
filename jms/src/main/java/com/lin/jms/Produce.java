package com.lin.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
@EnableScheduling
public class Produce {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 3000)
    public void send(){
        System.out.println(">>send");
        this.jmsTemplate.convertAndSend(queue, "Test Send");
    }
}
