package com.xhc.springcloud.demouser.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

@Configuration
public class BaseConfiguration {

	@Value("${basecfg.charset}")
	private String charset;

	@Value("${basecfg.connectTimeout}")
	private int connectTimeout;

	@Value("${basecfg.readTimeout}")
	private int readTimeout;

	@Bean
	public RestTemplate restTemplate(){
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		requestFactory.setConnectTimeout(connectTimeout);
		requestFactory.setReadTimeout(readTimeout);

		RestTemplate restTemplate = new RestTemplate(requestFactory);
		restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(Charset.forName(charset)));
		return restTemplate;
	}

}
