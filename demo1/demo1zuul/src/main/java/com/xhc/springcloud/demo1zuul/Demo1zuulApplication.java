package com.xhc.springcloud.demo1zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class Demo1zuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo1zuulApplication.class, args);
	}
}
