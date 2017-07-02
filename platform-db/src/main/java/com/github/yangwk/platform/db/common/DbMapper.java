package com.github.yangwk.platform.db.common;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;

import tk.mybatis.mapper.common.Mapper;

/**
 * 自定义使用的Mapper
 */
public interface DbMapper<T> extends Mapper<T> {
	//keyProperty指定主键名必须是id
	@Options(useGeneratedKeys = true, keyProperty = "id")
	@InsertProvider(type = DbProvider.class, method = "dynamicSQL")
	@Override
	int insert(T record);
}
