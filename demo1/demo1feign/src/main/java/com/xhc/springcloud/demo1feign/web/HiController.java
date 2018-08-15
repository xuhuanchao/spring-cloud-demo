package com.xhc.springcloud.demo1feign.web;

import com.xhc.springcloud.demo1feign.service.OtherWebRequest;
import com.xhc.springcloud.demo1feign.service.SchedualServiceHi;
import feign.Contract;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;

@RestController
public class HiController {

    @Autowired
    SchedualServiceHi schedualServiceHi;

    @Autowired
    OtherWebRequest otherWebRequest;

    @Autowired
    RestTemplate restTemplate;

    @Bean(name = "restTemplate")
    public static RestTemplate getInstance() {
        String charset = "gbk";
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> list = restTemplate.getMessageConverters();
        for (HttpMessageConverter<?> httpMessageConverter : list) {
            if(httpMessageConverter instanceof StringHttpMessageConverter) {
                ((StringHttpMessageConverter) httpMessageConverter).setDefaultCharset(Charset.forName(charset));
            }
        }
        return restTemplate;
    }



    @Configuration
    public class FooConfiguration {
        @Bean
        public Contract feignContract() {
            return new feign.Contract.Default();
        }

        @Bean
        public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
            return new BasicAuthRequestInterceptor("user", "password");
        }

    }

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return schedualServiceHi.sayHiFromClientOne(name);
    }


    @RequestMapping(value = "/searchKnows2",method = RequestMethod.GET)
    public String knows2(@RequestParam(value = "dataBase") String dataBase,
                         @RequestParam(value = "Field0") String Field0,
                         @RequestParam(value = "Word0") String Word0) throws Exception{
        String s = otherWebRequest.searchJson(dataBase, Field0, Word0);
        System.out.println(getEncoding(s));
        return s;
    }


    @RequestMapping(value = "/searchKnows",method = RequestMethod.GET)
    public String knows(@RequestParam(value = "dataBase") String dataBase,
                        @RequestParam(value = "Field0") String Field0,
                        @RequestParam(value = "Word0") String Word0) throws Exception{

        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://kde.cnki.net/KDE_WEB/GetData.svc/JsonEntrance?value=DataBase=CJFD%26Field0=SU%26Word0=subject%26PageIndex=0%26PageSize=10", String.class);
        String body = forEntity.getBody();

        return body;

        /*String s = otherWebRequest.searchJson(dataBase, Field0, Word0);

        System.out.println(new String(s.getBytes("ISO-8859-1"), "utf-8"));
        System.out.println(new String(s.getBytes("GBK"), "utf-8"));
        System.out.println(new String(s.getBytes("utf-8"), "utf-8"));
        System.out.println(new String(s.getBytes("GB2312"), "utf-8"));
        System.out.println(new String(s.getBytes("GB18030"), "utf-8"));

        System.out.println(getEncoding(s));
        return s;*/
    }


    public String getEncoding(String str){
        String encoding = "GBK";
        try {
            if (str.equals(new String(str.getBytes(),encoding))) {
                return encoding;
            }
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        encoding = "UTF-8";
        try {
            if (str.equals(new String(str.getBytes(),encoding))) {
                return encoding;
            }
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



        encoding = "ISO-8859-1";
        try {
            if (str.equals(new String(str.getBytes(),encoding))) {
                return encoding;
            }
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        encoding = "GB2312";
        try {
            if (str.equals(new String(str.getBytes(),encoding))) {
                return encoding;
            }
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }


}
