package com.github.yangwk.platform.soa.test.consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.yangwk.platform.soa.api.DemoService;

public class AppCxt4Consumer {
	
	private static ApplicationContext getApplicationContext(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		return ac;
	}
	
	protected static void test(){
		ApplicationContext ac = getApplicationContext();
		DemoService demoService = ac.getBean("soa-DemoService", DemoService.class);
		String result = demoService.sayHello();
		System.out.println(result);
	}

	
	public static void main(String[] args) {
		test();
	}
}
