package com.lin.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@EnableScheduling
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 3000)
    public void send() {
        String msg = UUID.randomUUID().toString() + "-test-msg";
        System.out.println(">>>send");
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE, RabbitMqConfig.AMQP_ROUTING_KEY, msg);
    }
}
