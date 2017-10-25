package com.mycat.monoeshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebMvcConfigurerAdapter {
	@Autowired
	SecurityInterceptor inteseptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(inteseptor).excludePathPatterns("/error","/login.html", "/account/login",
				"/session/**", "/detail.html").addPathPatterns("/","/**");
		
	}

}
