package com.github.yangwk.platform.service.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.yangwk.platform.bean.Page;
import com.github.yangwk.platform.db.mapper.user.UserMapper;
import com.github.yangwk.platform.db.mapper.user.UserUuidMapper;
import com.github.yangwk.platform.db.model.user.User;
import com.github.yangwk.platform.db.model.user.UserUuid;

@Service
public class UserServiceImpl implements UserService{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserUuidMapper userUuidMapper;

	@Override
	public List<User> findAll() {
		return userMapper.findAll();
	}

	@Override
	public User findById(Object id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<User> list(User user, Page page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());	//分页，在第1个查询sql有效
		
		List<User> users = userMapper.list(user);
		PageInfo<User> pageInfo = new PageInfo<User>(users);
		
		return pageInfo;
	}

	@Override
	public int update(User user) {
		int count = userMapper.updateByPrimaryKeySelective(user);
		return count;
	}

	@Override
	public int tx(User user) {
		int count = this.update(user);
		if(count > 0){
			log.info("更新用户数量{}",count);
			throw new RuntimeException("测试事务回滚");
		}
		
		return count;
	}

	@Override
	public List<UserUuid> list(UserUuid user) {
		return userUuidMapper.list(user);
	}

	@Override
	public int save(UserUuid user) {
		return userUuidMapper.insert(user);
	}
	
}
