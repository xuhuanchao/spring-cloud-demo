package com.xhc.springcloud.demo1client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@RestController
@PropertySource(value = "classpath:application.properties")
public class Demo1clientApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo1clientApplication.class, args);
    }

    @Value("${server.port}")
    String port;


    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        return "hi "+name+",i am from port:" +port;
    }

    @RequestMapping("/testKonws")
    public String testKnows() throws Exception{
        RestTemplate restTemplate = getInstance("gbk");
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://kde.cnki.net/KDE_WEB/GetData.svc/JsonEntrance?value=DataBase=CJFD%26Field0=SU%26Word0=subject%26PageIndex=0%26PageSize=10", String.class);
        String body = forEntity.getBody();
        System.out.println(body);

        System.out.println(new String(body.getBytes("GBK")));

        return body;
    }



    public static RestTemplate getInstance(String charset) {
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> list = restTemplate.getMessageConverters();
        for (HttpMessageConverter<?> httpMessageConverter : list) {
            if(httpMessageConverter instanceof StringHttpMessageConverter) {
                ((StringHttpMessageConverter) httpMessageConverter).setDefaultCharset(Charset.forName(charset));
            }
        }
        return restTemplate;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
