package com.mycat.monoeshop.controller;

import com.mycat.monoeshop.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ConsumerService consumerService;

    @GetMapping
    public String consumer() {
        return restTemplate.getForObject("http://ribbon-provider/", String.class);
    }

    @GetMapping("/fallback")
    public String consumerFallback() {
        return consumerService.consumer();
    }
}
