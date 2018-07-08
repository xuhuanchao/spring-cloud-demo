package com.xhc.springcloud.demouser;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class DemoUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoUserApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/getAge/{userId}")
    public String home(@PathVariable(value = "userId") String userId) {

        return "userAge is " + 20 + " , from service port is " + port;

    }

}
