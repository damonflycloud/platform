package com.github.yangwk.platform.controller.controller.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.yangwk.platform.controller.controller.BaseController;
import com.github.yangwk.platform.service.tx.MultipleService;

@Controller
@RequestMapping("/tx")
public class TxController extends BaseController{
	
	@Autowired
	private MultipleService multipleService;
	
	@ResponseBody
	@RequestMapping("/setData")
	public String setData(Model model) {
		int count = multipleService.setData();
		return JSON.toJSONString(count);
	}

	@ResponseBody
	@RequestMapping("/setData4Ex")
	public String setData4Ex(Model model) {
		int count = multipleService.setData4Ex();
		return JSON.toJSONString(count);
	}

	@ResponseBody
	@RequestMapping("/getData")
	public String getData(String redisKey, Model model) {
		int count = multipleService.getData(redisKey);
		return JSON.toJSONString(count);
	}
	
	
}
