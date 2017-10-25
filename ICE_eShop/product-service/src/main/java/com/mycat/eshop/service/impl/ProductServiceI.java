package com.mycat.eshop.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycat.eshop.intf.model.Product;
import com.mycat.eshop.intf.service.ProductService;
import com.zeroc.Ice.Current;

/**
 * Desc:
 *
 * @date: 27/08/2017
 * @author: Leader us
 */
public class ProductServiceI implements ProductService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceI.class);
    
	@Override
	public Product[] getProducts(Current current) {
		LOGGER.info("getProducts");
		Product[] all = new Product[3];
		Product app = new Product();
		app.id = 0;
		app.name = "Apple";
		app.price = 8000;
		app.desc = "Real Apple";
		all[0] = app;
		app = new Product();
		app.id = 1;
		app.name = "Car";
		app.price = 18000;
		app.desc = "My Car";
		all[1] = app;
		app = new Product();
		app.id = 2;
		app.name = "House";
		app.price = 50000;
		app.desc = "My House";
		all[2] = app;
		return all;
	}

	@Override
	public Product getProductById(int id, Current current) {
		Product app = new Product();
		app.id = 0;
		app.name = "Apple";
		app.price = 8000;
		app.desc = "Real Apple";
		return app;
	}

}
