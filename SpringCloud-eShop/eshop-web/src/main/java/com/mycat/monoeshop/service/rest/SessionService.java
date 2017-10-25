package com.mycat.monoeshop.service.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.mycat.monoeshop.model.Result;
import com.mycat.monoeshop.model.ResultEnum;

/**
 * Desc:
 *
 * @date: 27/08/2017
 * @author: Leader us
 */
@FeignClient(name = "micro-gateway", fallback = SessionService.HystrixSessionService.class)
public interface SessionService {
    Logger LOGGER = LoggerFactory.getLogger(SessionService.class);
    public static final int RESULT_SUCCESS = 200;
    @GetMapping(value = "/session/token")
    Result tokenCheck(@RequestHeader("Cookie") String sessionId);

    @Component
    class HystrixSessionService implements SessionService {
        @Override
        public Result tokenCheck(String sessionId) {
            LOGGER.warn("token check error");
            return new Result(ResultEnum.ERROR);
        }
    }

	
}
