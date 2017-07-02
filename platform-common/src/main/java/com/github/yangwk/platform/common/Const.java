package com.github.yangwk.platform.common;

import com.github.yangwk.ydtutil.prop.PropUtils;

/**
 * 常量定义
 */
public interface Const {
	final static PropUtils prop = PropUtils.use( "const.properties" );	//文件名
	
	final static Integer PAGE_NUM = prop.getInt("pageNum");
	final static Integer PAGE_SIZE = prop.getInt("pageSize");
	
	
}
