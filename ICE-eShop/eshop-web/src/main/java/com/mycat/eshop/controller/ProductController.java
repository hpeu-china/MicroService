package com.mycat.eshop.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycat.eshop.intf.model.Product;
import com.mycat.eshop.intf.service.CartServicePrx;
import com.mycat.eshop.intf.service.ProductServicePrx;

import io.mycat.ice.utils.ICEClientUtil;

/**
 * Desc:
 *
 * @date: 27/08/2017
 * @author: Leader us
 */
@Controller
@RequestMapping("/products")
public class ProductController {


	@RequestMapping("")
	@ResponseBody
	public Product[] getProducts() {
		ProductServicePrx productServicePrx = (ProductServicePrx) ICEClientUtil.getSerivcePrx(ProductServicePrx.class);
		return productServicePrx.getProducts();
		 
	}

	@RequestMapping("{id}")
	@ResponseBody
	public Product getProductById(@PathVariable Integer id) {
		//return productService.getProductById(id);
		return null;
	}
}
