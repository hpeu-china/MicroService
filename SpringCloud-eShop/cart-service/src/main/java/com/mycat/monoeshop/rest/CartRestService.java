package com.mycat.monoeshop.rest;

import java.util.List;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycat.monoeshop.model.CartRecord;
import com.mycat.monoeshop.model.Result;
import com.mycat.monoeshop.service.CartService;

/**
 * Desc:
 *
 * @date: 27/08/2017
 * @author: Leader us
 */
@RestController()
@RequestMapping("/cart")
public class CartRestService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CartRestService.class);
	@Autowired
	private CartService cartService;

	@RequestMapping("records")
	public List<CartRecord> getProductsByUsername(HttpServletRequest request) {
		LOGGER.info("get cart for user " + request.getSession().getId());
		Stream.of(request.getCookies()).forEach(a -> {
			System.out.println("yyy cookie " + a.getName() + " " + a.getValue());
		});
		String userName = request.getHeader("accountName");
		LOGGER.info("get cart for user " + userName);
		return cartService.getProductsByUsername(userName);
	}

	@RequestMapping("add-cart")
	public Result<String> addProductToCart(@RequestBody CartRecord cartRecord, HttpServletRequest request) {
		cartRecord.setUsername(request.getHeader("accountName"));
		LOGGER.info("add goods to cart  " + cartRecord);
		return cartService.addProductToCart(cartRecord);
	}
}
