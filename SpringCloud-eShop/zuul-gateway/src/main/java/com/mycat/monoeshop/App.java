package com.mycat.monoeshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Desc:
 *
 * @date: 27/08/2017
 * @author: Leader us
 */
@SpringBootApplication
@EnableRedisHttpSession
@EnableZuulProxy
public class App {
	/**
	 * 记录用户Session是否登录过
	 */
	public final static String SESSION_KEY = "user_sid";

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
