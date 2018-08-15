package com.xhc.springcloud.demouser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping(value = "/test")
public class TestController {

	@Autowired
	private RestTemplate restTemplate;


	@RequestMapping(value = "/getPageInfo", method = RequestMethod.GET)
	public String getPageInfo(@RequestParam(value = "url") String url) {
		if(url.indexOf("http://") == -1 || url.indexOf("https://") == -1){
			url = "http://" + url;
		}
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		return responseEntity.getBody();
	}

}
