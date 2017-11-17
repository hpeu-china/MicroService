package com.mycat.monoeshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin.server.EnableZipkinServer;

/**
 * Desc: SpringBootAdmin App starter
 *
 * @date: 14/11/2017
 * @author: gaul
 */
@EnableZipkinServer
@EnableDiscoveryClient
@SpringBootApplication
public class ZipkinApp {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinApp.class, args);
    }
}
