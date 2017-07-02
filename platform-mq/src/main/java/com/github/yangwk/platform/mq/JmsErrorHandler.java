package com.github.yangwk.platform.mq;

import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;

@Component
public class JmsErrorHandler implements ErrorHandler {

	@Override
	public void handleError(Throwable t) {
		t.printStackTrace();
	}
	
	
}
