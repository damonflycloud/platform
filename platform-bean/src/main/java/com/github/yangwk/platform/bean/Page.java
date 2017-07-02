package com.github.yangwk.platform.bean;

import com.github.yangwk.platform.common.Const;

public class Page {
	private Integer pageNum;
	private Integer pageSize;
	
	public Integer getPageNum() {
		if(pageNum == null){
			pageNum = Const.PAGE_NUM;
		}
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageSize() {
		if(pageSize == null){
			pageSize = Const.PAGE_SIZE;
		}
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
