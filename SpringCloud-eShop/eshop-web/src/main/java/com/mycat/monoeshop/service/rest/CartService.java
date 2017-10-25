package com.mycat.monoeshop.service.rest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.mycat.monoeshop.model.CartRecord;
import com.mycat.monoeshop.model.Result;

/**
 * Desc:
 *
 * @date: 27/08/2017
 * @author: Leader us
 */

@FeignClient(name = "micro-gateway", fallback = CartService.HystrixCartService.class)
public interface CartService {
	
	@GetMapping("/cart/add-cart")
    Result<String>  addProductToCart(@RequestHeader("Cookie") String sessionId,@RequestBody CartRecord cartRecord);

    @GetMapping("/cart/records")
    List<CartRecord> getProductsByUsername(@RequestHeader("Cookie") String sessionId);

    @Component
	class HystrixCartService implements CartService {
    	private static final Logger LOGGER = LoggerFactory.getLogger(CartService.class);
    	@Override
		public List<CartRecord> getProductsByUsername(@RequestHeader("Cookie") String sessionId) {
			LOGGER.warn("Hystrix occured :CartRecord");
			CartRecord prod=new CartRecord();
			prod.setCount(0);
			prod.setProductId(0);
			prod.setProductName("Error");
			prod.setProductPrice(BigDecimal.ZERO);
			ArrayList<CartRecord> rest=new ArrayList<>();
			rest.add(prod);
			return rest;
		}

		@Override
		public Result<String> addProductToCart(@RequestHeader("Cookie") String sessionId,CartRecord cartRecord) {
			LOGGER.warn("Hystrix occured :addProductToCart");
			return new Result<String>(com.mycat.monoeshop.model.ResultEnum.ERROR);
		}

    }
}