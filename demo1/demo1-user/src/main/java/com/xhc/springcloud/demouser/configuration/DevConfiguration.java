package com.xhc.springcloud.demouser.configuration;

import com.xhc.springcloud.demouser.objwrap.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("dev")
public class DevConfiguration {

	@Bean(name = "devUser")
	public User devUser(){
		User u = new User();
		u.setLoginName("xhc");
		u.setSex(1l);
		u.setUserId(10000l);
		u.setUserName("xhc");
		return u;
	}
}
