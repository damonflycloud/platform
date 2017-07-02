package com.github.yangwk.platform.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.github.yangwk.platform.service.user.UserService;

@Aspect
@Component
public class AspectController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserService userService;
	
	@Around(value = "execution(* com.github.yangwk.platform.controller..*.*(..))")
	public Object aroundMethod(ProceedingJoinPoint pjd) throws Throwable {
		logger.info("coming in com.github.yangwk.platform.aop.AspectController.aroundMethod(ProceedingJoinPoint)");
		
		if( pjd.getTarget().getClass().isAnnotationPresent(Controller.class) ){
			logger.info( JSON.toJSONString( userService.findAll() ) );
		}
		
		Object[] args = pjd.getArgs();
		Object result = pjd.proceed( args );
		return result;
	}
	
	
}
