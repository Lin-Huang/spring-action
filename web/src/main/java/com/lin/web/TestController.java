package com.lin.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class TestController {
    @Autowired
    private SimpMessageSendingOperations messaging;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @MessageMapping("/marco")
    public void handleShout(Shout shout) {
        log.info("Received message:" + shout.getMessage());
        shout.setMessage("change");
        messaging.convertAndSend("/topic/notice", shout);
        shout.setMessage("Hello, User-1!");
        messaging.convertAndSendToUser("1", "/message", shout);
    }
}
