package com.xhc.springcloud.demouser;

import com.xhc.springcloud.demouser.util.SpringUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@EnableEurekaClient
@RestController
@ComponentScan
public class DemoUserApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(DemoUserApplication.class, args);
        SpringUtil.setApplicationContext(applicationContext);
//        System.exit(SpringApplication.exit(applicationContext));
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/getAge/{userId}")
    public String home(@PathVariable(value = "userId") String userId) {

        return "userAge is " + 20 + " , from service port is " + port;

    }


    @Bean
    public ExitCodeGenerator exitCodeGenerator() {
        return () -> 42;
    }

}
