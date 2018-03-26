package com.mycat.monoeshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {
    @Autowired
    private Environment env;

    @GetMapping()
    public String provider() {
        return String.format("result from %s: %s", env.getProperty("spring.application.name"), env.getProperty("server.port"));
    }
}
