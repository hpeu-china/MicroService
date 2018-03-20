package com.mycat.monoeshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private Channel channel;

    //    @SendTo(Channel.MY_OUTPUT)
    public void sender(String msg) {
        channel.myOutput().send(MessageBuilder.withPayload(msg).build());
//        return "msg: " + msg;
    }

    @GetMapping("/test")
    public String test(@RequestParam String msg) {
        sender(msg);
        return msg;
    }
}
