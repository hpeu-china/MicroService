package com.mycat.monoeshop.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumerService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "consumerFallback")
    public String consumer() {
        return restTemplate.getForObject("http://ribbon-provider/", String.class);
    }

    public String consumerFallback() {
        return "result from consumer fallback";
    }
}
