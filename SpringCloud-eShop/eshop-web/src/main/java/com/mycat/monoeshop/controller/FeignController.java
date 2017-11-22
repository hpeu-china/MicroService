package com.mycat.monoeshop.controller;

import com.mycat.monoeshop.service.rest.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Desc: just for zuul test
 *
 * @date: 22/11/2017
 * @author: gaul
 */
@RestController
public class FeignController {
    @Autowired
    private FeignService feignService;

    @GetMapping("/feign")
    public String service() {
        return feignService.service();
    }
}
