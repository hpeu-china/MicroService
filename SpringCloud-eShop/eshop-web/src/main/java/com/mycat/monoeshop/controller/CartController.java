package com.mycat.monoeshop.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycat.monoeshop.App;
import com.mycat.monoeshop.model.CartRecord;
import com.mycat.monoeshop.model.Result;
import com.mycat.monoeshop.service.rest.CartService;

/**
 * Desc:
 *
 * @date: 27/08/2017
 * @author: Leader us
 */
@Controller
@RequestMapping("/cart")
public class CartController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

	@Autowired
	private CartService cartService;

	@RequestMapping("records")
	@ResponseBody
	public List<CartRecord> getProductsByUsername(@CookieValue(App.SESSION_KEY) String sessionId) {
		LOGGER.info("get cart for user " + sessionId);
		return cartService.getProductsByUsername("SESSION="+sessionId);
	}

	@RequestMapping("add-cart")
	@ResponseBody
	public Result<String> addProductToCart(@CookieValue(App.SESSION_KEY) String sessionId,
			@RequestBody CartRecord cartRecord) {
		cartRecord.setUsername(sessionId);
		LOGGER.info("add goods to cart  " + cartRecord);
		return cartService.addProductToCart("SESSION="+sessionId, cartRecord);
	}
}
