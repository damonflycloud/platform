package com.github.yangwk.platform.service.tx;

public interface MultipleService {
	
	int setData();
	
	int setData4Ex();
	
	int getData(String redisKey);
}
