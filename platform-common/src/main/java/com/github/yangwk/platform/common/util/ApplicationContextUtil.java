package com.github.yangwk.platform.common.util;

import org.springframework.context.ApplicationContext;

public class ApplicationContextUtil {
	
	private static ApplicationContext applicationContext;
	
	private ApplicationContextUtil(){}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public synchronized static void setApplicationContext(ApplicationContext ac) {
		if(applicationContext == null){
			applicationContext = ac;
		}
	}
	
}
