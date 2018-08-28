package com.xhc.springcloud.demouser.controller;

import com.xhc.springcloud.demouser.objwrap.*;
import com.xhc.springcloud.demouser.objwrap.entity.User;
import com.xhc.springcloud.demouser.util.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
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

	@Autowired
	private WorkGroupProperties workGroupProperties;

	@Autowired
	private WorkGroupProperties2 workGroupProperties2;

	@Autowired
	private WorkGroupProperties3 workGroupProperties3;

	@Autowired
	private TestListMapProperties testListMap;


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

	@RequestMapping(value = "/getProperties", method = RequestMethod.GET)
	public CommResp<Map<String, Object>> getProperties(){
		CommResp<Map<String, Object>> result = new CommResp<>();
		result.makeSuccessResp();
		Map<String, Object> map = new HashMap<>();
		map.put("workGroupProperties", workGroupProperties);
		map.put("workGroupProperties2", workGroupProperties2);
		map.put("workGroupProperties3", workGroupProperties3);
		result.setData(map);
		return result;
	}

	@RequestMapping(value = "/getListMapProperties", method = RequestMethod.GET)
	public CommResp<TestListMapProperties> getListMapProperties(){
		CommResp<TestListMapProperties> result = new CommResp<>();
		result.makeSuccessResp().setData(testListMap);
		return result;
	}

	@GetMapping(value = "/getDevUser")
	public CommResp<User> getDevUser(){
		CommResp<User> result = new CommResp<>();
		User devUser = (User)SpringUtil.getBean("devUser");
		result.makeSuccessResp().setData(devUser);
		return result;
	}
}
