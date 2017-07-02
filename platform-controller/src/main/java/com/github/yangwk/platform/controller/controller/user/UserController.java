package com.github.yangwk.platform.controller.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.github.yangwk.platform.bean.Page;
import com.github.yangwk.platform.common.annotation.RequestComment;
import com.github.yangwk.platform.controller.controller.BaseController;
import com.github.yangwk.platform.db.model.user.User;
import com.github.yangwk.platform.db.model.user.UserUuid;
import com.github.yangwk.platform.service.user.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	@RequestComment(value="查找所有用户")
	@ResponseBody
	@RequestMapping("/findAll")
	public String findAll(Model model) {
		List<User> users = userService.findAll();
		return JSON.toJSONString(users);
	}
	
	@RequestComment(value="查找用户-根据id")
	@ResponseBody
	@RequestMapping("/findById")
	public User findById(Long id,String name,Model model) {
		log.info("访问参数name的值为{}", name);
		User user = userService.findById(id);
		return user;
	}
	
	@RequestComment(value="查找用户-条件域和分页")
	@RequestMapping("/list")
	public String list(User user, Page page, Model model){
		PageInfo<User> pageInfo = userService.list(user, page);
		model.addAttribute("pageInfo", pageInfo);
		return "/view/user/list";
	}

	
	@RequestComment(value="更新用户")
	@ResponseBody
	@RequestMapping("/update")
	public String update(User user, Model model){
		int count = userService.update(user);
		String message = "更新用户数量"+count;
		return message;
	}

	@RequestComment(value="事务")
	@ResponseBody
	@RequestMapping("/tx")
	public String tx(User user, Model model){
		int count = userService.tx(user);
		String message = "更新用户数量"+count;
		return message;
	}
	
	
	@RequestMapping("/save")
	@ResponseBody
	public String save(UserUuid user,Model model){
		int count = userService.save(user);
		return JSON.toJSONString(count);
	}
	
}
