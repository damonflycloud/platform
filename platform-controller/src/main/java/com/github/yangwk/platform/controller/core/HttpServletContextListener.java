package com.github.yangwk.platform.controller.core;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.github.yangwk.platform.common.util.ApplicationContextUtil;

public class HttpServletContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(context);
		ApplicationContextUtil.setApplicationContext(wac);	//获取spring context上下文
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
