package com.xhc.springcloud.demo1server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Demo1serverApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo1serverApplication.class, args);
    }
}
