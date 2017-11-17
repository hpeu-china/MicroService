package com.mycat.monoeshop;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Desc: SpringBootAdmin App starter
 *
 * @date: 14/11/2017
 * @author: gaul
 */
@EnableAdminServer
@EnableDiscoveryClient
@SpringBootApplication
public class AdminApp {
    public static void main(String[] args) {
        SpringApplication.run(AdminApp.class, args);
    }
}
