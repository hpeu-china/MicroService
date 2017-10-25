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

import com.mycat.monoeshop.model.Product;

/**
 * Desc:
 *
 * @date: 27/08/2017
 * @author: Leader us
 */

@FeignClient(name = "micro-gateway", fallback = ProductService.HystrixProductService.class)
public interface ProductService {

	@GetMapping("/products/all")
	List<Product> getProducts();

	@GetMapping("/products/{id}")
	Product getProductById(@PathVariable("id") Integer id);

	@Component
	class HystrixProductService implements ProductService {
		Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

		@Override
		public List<Product> getProducts() {
			LOGGER.warn("Hystrix occured: getProducts");
			Product prod = new Product();
			prod.setId(0);
			prod.setName("Error");
			prod.setPrice(BigDecimal.ZERO);
			prod.setDesc("Erro occured");
			ArrayList<Product> rest = new ArrayList<>();
			rest.add(prod);
			return rest;
		}

		@Override
		public Product getProductById(Integer id) {
			LOGGER.warn("Hystrix occured: getProductById");
			return null;
		}
	}
}