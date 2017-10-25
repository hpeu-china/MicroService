package com.mycat.monoeshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mycat.monoeshop.filter.LoginPostFilter;
import com.mycat.monoeshop.filter.SecurityPreFilter;
import com.netflix.zuul.ZuulFilter;

/**
 * Desc:
 *
 * @date: 02/07/2017
 * @author: gaozhiwen
 */
@Configuration
public class FilterConfig {
    @Bean
    public ZuulFilter securityPreFilter() {
        return new SecurityPreFilter();
    }

    @Bean
    public ZuulFilter loginPostFilter() {
        return new LoginPostFilter();
    }
}
