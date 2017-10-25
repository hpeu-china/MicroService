package com.mycat.monoeshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Desc:
 *
 * @date: 27/08/2017
 * @author: Leader us
 */
@SpringBootApplication
@EnableEurekaServer
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
