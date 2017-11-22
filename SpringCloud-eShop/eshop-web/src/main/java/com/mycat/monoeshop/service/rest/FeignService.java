package com.mycat.monoeshop.service.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Desc: just for zuul test
 *
 * @date: 27/08/2017
 * @author: Leader us
 */
@FeignClient(name = "eshop-zuul-gateway", fallback = FeignService.HystrixFeignService.class)
public interface FeignService {
    @GetMapping("/feign")
    String service();

    @Component
    class HystrixFeignService implements FeignService {
        private static final Logger LOGGER = LoggerFactory.getLogger(HystrixFeignService.class);

        @Override
        public String service() {
            LOGGER.error("error in handle service");
            return "mock feign result";
        }
    }
}