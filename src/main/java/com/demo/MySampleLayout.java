package com.demo;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.LayoutBase;

public class MySampleLayout extends LayoutBase<ILoggingEvent> {
	//로그앞에 세션아이디 넣기 .. logback.xml appender에 등록해줘야 작동함
	@Override
	public String doLayout(ILoggingEvent event) {
		RequestAttributes attrs = RequestContextHolder.getRequestAttributes();
		
		return attrs.getSessionId();
	}

}
