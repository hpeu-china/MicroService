package com.mycat.monoeshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Desc: just for zuul test
 *
 * @date: 27/08/2017
 * @author: Leader us
 */
@RestController
public class FeignController {
    @GetMapping("/feign")
    public String service() {
        return "result from zuul";
    }
}
