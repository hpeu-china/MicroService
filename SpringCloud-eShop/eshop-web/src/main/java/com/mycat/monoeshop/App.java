package com.mycat.monoeshop;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Desc:
 *
 * @date: 27/08/2017
 * @author: Leader us
 */
@EnableFeignClients
@SpringCloudApplication
public class App{
	public static final String SESSION_KEY = "SESSION";

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
