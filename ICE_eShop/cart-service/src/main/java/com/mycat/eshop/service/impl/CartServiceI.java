package com.mycat.eshop.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycat.eshop.intf.model.CartRecord;
import com.mycat.eshop.intf.service.CartService;
import com.zeroc.Ice.Current;

/**
 * Desc:
 *
 * @date: 27/08/2017
 * @author: Leader us
 */
public class CartServiceI implements CartService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CartServiceI.class);
	private ConcurrentHashMap<String, List<CartRecord>> userCartMap = new ConcurrentHashMap<>();

	@Override
	public CartRecord[] getProductsByUsername(String username, Current current) {
		LOGGER.info("get cart for user " + username);
		List<CartRecord> carts = getUserCart(username);
		return carts.toArray(new CartRecord[carts.size()]);
	}

	private List<CartRecord> getUserCart(String username) {
		List<CartRecord> carts = userCartMap.get(username);
		if (carts == null) {
			carts = new LinkedList<CartRecord>();
			userCartMap.put(username, carts);
		}
		return carts;
	}

	@Override
	public void addProductToCart(CartRecord cartRecord, Current current) {
		List<CartRecord> carts = getUserCart(cartRecord.username);
		boolean added = false;
		for (CartRecord cart : carts) {
			if (cart.productId == cartRecord.productId) {
				cart.count++;
				added = true;
				break;
			}
		}
		if (!added) {
			carts.add(cartRecord);
		}
	}

}
