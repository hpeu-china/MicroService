package com.mycat.eshop.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycat.eshop.App;
import com.mycat.eshop.intf.model.Account;
import com.mycat.eshop.intf.model.CartRecord;
import com.mycat.eshop.intf.service.CartServicePrx;
import com.mycat.eshop.model.Result;
import com.mycat.eshop.model.ResultEnum;

import io.mycat.ice.utils.ICEClientUtil;

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

	@RequestMapping("records")
	@ResponseBody
	public com.mycat.eshop.intf.model.CartRecord[] getProductsByUsername(HttpServletRequest request) {
		Account account = (Account) request.getSession().getAttribute(App.SESSION_KEY);
		LOGGER.info("get cart for user " + account.name);
		CartServicePrx cartServicePrx = (CartServicePrx) ICEClientUtil.getSerivcePrx(CartServicePrx.class);
		return cartServicePrx.getProductsByUsername(account.name);

	}

	@RequestMapping("add-cart")
	@ResponseBody
	public Result<String> addProductToCart(HttpServletRequest request, @RequestBody CartRecord cartRecord) {
		Account account = (Account) request.getSession().getAttribute(App.SESSION_KEY);
		cartRecord.username=account.name;
		LOGGER.info("add goods to cart  " + cartRecord);
		CartServicePrx cartServicePrx = (CartServicePrx) ICEClientUtil.getSerivcePrx(CartServicePrx.class);
		cartServicePrx.addProductToCart(cartRecord);
	 
		return new Result(ResultEnum.SUCCESS);
		
	}
}
