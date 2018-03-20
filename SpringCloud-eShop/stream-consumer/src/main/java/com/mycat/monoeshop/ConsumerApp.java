package com.mycat.monoeshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import java.nio.charset.Charset;

@EnableBinding(Channel.class)
@SpringBootApplication
public class ConsumerApp {
    @StreamListener(Channel.MY_INPUT)
    public void receiver(byte[] msg) {
        System.out.println("receive message: " + new String(msg, Charset.defaultCharset()));
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp.class, args);
    }
}
