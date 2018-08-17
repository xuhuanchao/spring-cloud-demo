package com.xhc.springcloud.demouser.controller;

import com.xhc.springcloud.demouser.objwrap.CommResp;
import com.xhc.springcloud.demouser.util.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping(value = "/test")
public class TestController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	ExitCodeGenerator exitCodeGenerator;

	@Value("${name}")
	private String name;




	@RequestMapping(value = "/getPageInfo", method = RequestMethod.GET)
	public String getPageInfo(@RequestParam(value = "url") String url) {
		if(url.indexOf("http://") == -1 || url.indexOf("https://") == -1){
			url = "http://" + url;
		}
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		return responseEntity.getBody();
	}

	@RequestMapping(value = "/exit", method = RequestMethod.GET)
	public CommResp shutDown(){
		CommResp result = new CommResp();

		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
		executor.schedule(
				() -> {System.exit(SpringApplication.exit(SpringUtil.getApplicationContext()));},
				5, TimeUnit.SECONDS
		);

		result.makeSuccessResp();
		return result;
	}

	@RequestMapping(value = "/getVarName", method = RequestMethod.GET)
	public CommResp<String> getVarName() {
		CommResp<String> result = new CommResp<>();
		result.makeSuccessResp();
		result.setMsg(name);
		return result;
	}
}
