package com.github.yangwk.platform.db.mapper.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.github.yangwk.platform.db.common.DbMapper;
import com.github.yangwk.platform.db.model.user.User;
import com.github.yangwk.platform.db.model.user.UserUuid;


public interface UserUuidMapper extends DbMapper<UserUuid> {
	
	public List<UserUuid> findAll();
	
	@Select("select * from user_uuid where id = #{id}")
	@ResultType(UserUuid.class)
	public User findById(@Param("id")Object id);
	
	public List<UserUuid> list(@Param("user")UserUuid user);
	
	
}