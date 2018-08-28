package com.xhc.springcloud.demouser;

import com.xhc.springcloud.demouser.util.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnableEurekaClient
@RestController
@ComponentScan
public class DemoUserApplication {

    private static Logger logger = LoggerFactory.getLogger(DemoUserApplication.class);

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(DemoUserApplication.class, args);
        SpringUtil.setApplicationContext(applicationContext);

        //打印激活的配置
        String[] profiles = applicationContext.getEnvironment().getActiveProfiles();
        StringBuilder activedProfiles = new StringBuilder();
        Arrays.stream(profiles).forEach(s -> activedProfiles.append(s+","));
        logger.info("Actived profiles: " + activedProfiles.delete(activedProfiles.length()-1,activedProfiles.length()));
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
