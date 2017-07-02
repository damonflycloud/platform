package com.github.yangwk.platform.db.mapper.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.github.yangwk.platform.db.common.DbMapper;
import com.github.yangwk.platform.db.model.user.User;


public interface UserMapper extends DbMapper<User> {
	
	public List<User> findAll();
	
	@Select("select * from user where id = #{id}")
	@ResultType(com.github.yangwk.platform.db.model.user.User.class)
	public User findById(@Param("id")Object id);
	
	public List<User> list(@Param("user")User user);
	
	
}