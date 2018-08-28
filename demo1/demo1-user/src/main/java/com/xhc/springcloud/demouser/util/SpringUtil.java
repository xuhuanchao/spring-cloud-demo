package com.xhc.springcloud.demouser.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

public class SpringUtil {

	private static Logger logger = LoggerFactory.getLogger(SpringUtil.class);

	private static ApplicationContext applicationContext = null;


	public static void setApplicationContext(ApplicationContext applicationContext)  {
		if(SpringUtil.applicationContext == null){
			SpringUtil.applicationContext  = applicationContext;
		}

	}

	//获取applicationContext
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	//通过name获取 Bean.
	public static Object getBean(String name){
		try {
			return getApplicationContext().getBean(name);
		} catch (BeansException e) {
			e.printStackTrace();
			logger.error("没有找到name为"+name+"的Bean", e);
			return null;
		}

	}

	//通过class获取Bean.
	public static <T> T getBean(Class<T> clazz){
		return getApplicationContext().getBean(clazz);
	}

	//通过name,以及Clazz返回指定的Bean
	public static <T> T getBean(String name,Class<T> clazz){
		return getApplicationContext().getBean(name, clazz);
	}
}
