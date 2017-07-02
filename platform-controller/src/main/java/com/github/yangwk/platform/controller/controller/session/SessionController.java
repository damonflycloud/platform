package com.github.yangwk.platform.controller.controller.session;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.yangwk.platform.controller.controller.BaseController;

@Controller
@RequestMapping("/session")
public class SessionController extends BaseController{
	
	@ResponseBody
	@RequestMapping("/setAttr")
	public String setAttr(String key, String val, HttpServletRequest request) {
		request.getSession(true).setAttribute(key, val);
		return "";
	}

	@ResponseBody
	@RequestMapping("/getAttr")
	public String getAttr(String key, HttpServletRequest request) {
		String val = request.getSession(false).getAttribute(key).toString();
		return val;
	}
	
}
