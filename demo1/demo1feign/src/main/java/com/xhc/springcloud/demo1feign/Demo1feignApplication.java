package com.xhc.springcloud.demo1feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Demo1feignApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo1feignApplication.class, args);
    }
}
