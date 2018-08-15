package com.xhc.springcloud.demo1feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "knows", url = "http://kde.cnki.net/KDE_WEB/GetData.svc")
public interface OtherWebRequest {

	@RequestMapping(value = "/JsonEntrance",method = RequestMethod.GET, headers = "Content-Type=text/html;charset=utf8")
	String searchJson(
			@RequestParam(value = "value=DataBase") String dataBase,
			@RequestParam(value = "Field0") String Field0,
			@RequestParam(value = "Word0") String Word0
			);
}
