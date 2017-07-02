package com.github.yangwk.platform.controller.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseController {
	//子Controller使用此Logger即可，不应该再定义
	public Logger log = LoggerFactory.getLogger(this.getClass());
	
	//definitation
	//some method
}
