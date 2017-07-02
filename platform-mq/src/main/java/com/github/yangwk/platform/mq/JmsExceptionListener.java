package com.github.yangwk.platform.mq;

import javax.jms.ExceptionListener;
import javax.jms.JMSException;

import org.springframework.stereotype.Component;

@Component
public class JmsExceptionListener implements ExceptionListener{
	
	@Override
    public void onException( JMSException e )
    {
        e.printStackTrace();
    }
}