package com.mycat.monoeshop.service.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Desc:
 *
 * @date: 27/08/2017
 * @author: Leader us
 */
@FeignClient(name = "micro-gateway", fallback = AccountService.HystrixAccountService.class)
public interface AccountService {
	@PostMapping("/account/login")
	String login(@RequestParam("username") String username, @RequestParam("password") String password);

	@Component
	class HystrixAccountService implements AccountService {
		private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);
		@Override
		public String login(String username, String password) {
			LOGGER.warn("Hystrix occured: login ");
			return null;
		}
	}
}