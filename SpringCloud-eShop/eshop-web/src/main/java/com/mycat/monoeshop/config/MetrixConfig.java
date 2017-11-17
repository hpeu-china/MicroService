package com.mycat.monoeshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Desc:
 *
 * @date: 14/11/2017
 * @author: gaul
 */
@Configuration
public class MetrixConfig {
    @Bean
    public MyMetrix myMetrix() {
        return new MyMetrix();
    }
}
