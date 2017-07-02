package com.github.yangwk.platform.soa.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.github.yangwk.platform.db.model.user.User;
import com.github.yangwk.platform.service.user.UserService;
import com.github.yangwk.platform.soa.api.DemoService;

//不加@Service注解
public class DemoServiceImpl implements DemoService{
	
	@Autowired
	private UserService userService;

	@Override
	public String sayHello() {
		List<User> users = userService.findAll();
		return JSON.toJSONString(users);
	}

}
