package com.github.yangwk.platform.service.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.github.yangwk.platform.bean.Page;
import com.github.yangwk.platform.db.model.user.User;
import com.github.yangwk.platform.db.model.user.UserUuid;

public interface UserService {
	List<User> findAll();
	
	User findById(Object id);
	
	PageInfo<User> list(User user,Page page);
	
	int update(User user);
	
	int tx(User user);
	
	List<UserUuid> list(@Param("user")UserUuid user);
	
	int save(UserUuid user);
}
