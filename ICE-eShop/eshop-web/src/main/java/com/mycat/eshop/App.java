package com.mycat.eshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Desc:
 *
 * @date: 27/08/2017
 * @author: Leader us
 */

@SpringBootApplication
public class App{
	public static final String SESSION_KEY = "SESSION";

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
