package com.github.yangwk.platform.service.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.github.yangwk.platform.db.mapper.user.UserMapper;
import com.github.yangwk.platform.db.model.user.User;

@Service
public class MultipleServiceImpl implements MultipleService{

	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
    private JmsTemplate jmsTemplate;
	
	
	@Override
	public int setData() {
		redisTemplate.opsForValue().set("haha", "redis haha");
		
		User user = new User();
		user.setId(1L);
		user.setName("test Tx");
		userMapper.updateByPrimaryKey(user);
		
		jmsTemplate.setPubSubDomain(true);
    	jmsTemplate.convertAndSend("topic.spring.tx", "mq haha");
    	
		return 0;
	}

	@Override
	public int setData4Ex() {
		redisTemplate.opsForValue().set("haha2", "redis haha2");
		
		User user = new User();
		user.setId(1L);
		user.setName("test Tx2");
		userMapper.updateByPrimaryKey(user);
		
		jmsTemplate.setPubSubDomain(true);
    	jmsTemplate.convertAndSend("topic.spring.tx", "mq haha2");
    	
    	if(user.getId()> -1 ) throw new RuntimeException("测试事务");
		return 0;
	}

	@Override
	public int getData(String redisKey) {
		String redisval = redisTemplate.opsForValue().get(redisKey);
		User user = userMapper.selectByPrimaryKey(1L);
		
		System.out.println(redisval);
		System.out.println(JSON.toJSON(user));
		return 0;
	}

}
