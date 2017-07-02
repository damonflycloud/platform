package com.github.yangwk.platform.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DemoTask {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	//每1分钟
    @Scheduled(cron="0 0/1 * * * ?")
    public void executeTask(){
    	log.info("DemoTask");
    }

}
