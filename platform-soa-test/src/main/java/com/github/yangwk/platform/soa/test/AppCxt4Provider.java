package com.github.yangwk.platform.soa.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppCxt4Provider {
	
	private static ApplicationContext getApplicationContext(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		return ac;
	}
	
	protected static void startProvider(){
		getApplicationContext();
	}

	
	public static void main(String[] args) {
		startProvider();
	}
}
