package com.github.yangwk.platform.controller.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 统一异常处理
 * @author yangwk
 */
@Component
public class ExceptionHandler implements HandlerExceptionResolver {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		log.error(ex.getMessage(), ex);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/view/error");
		mav.addObject("message", ex.getMessage());
        return mav;
	}
	
    
}
