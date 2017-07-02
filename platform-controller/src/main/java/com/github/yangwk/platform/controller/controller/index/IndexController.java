package com.github.yangwk.platform.controller.controller.index;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.yangwk.platform.common.annotation.RequestComment;
import com.github.yangwk.platform.controller.controller.BaseController;

@Controller
public class IndexController extends BaseController{
	
	@RequestComment("首页")
	@RequestMapping(value = {"index", ""})
	public String index(Model model, HttpServletRequest request){
		return "/view/index";
	}
}
