package com.xhc.springcloud.demo1zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class Demo1zuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo1zuulApplication.class, args);
	}

	/**
	 * servcieId = serviceName-v1 形势
	 * zuul 支持 v1/serviceName/ url的请求
	 * @return
	 */
	@Bean
	public PatternServiceRouteMapper serviceRouteMapper() {
		return new PatternServiceRouteMapper(
				"(?<name>^.+)-(?<version>v.+$)",
				"${version}/${name}");
	}
}
