package com.huaxinshengyuan.socknow.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.CustomizableTraceInterceptor;

public class TraceInterceptor extends CustomizableTraceInterceptor {

	private static final long serialVersionUID = 287162721460370957L;
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void writeToLog(Log logger, String message, Throwable ex) {
		if (ex != null) {
			log.debug(message, ex);
		} else {
			log.debug(message);
		}
	}

	@Override
	protected boolean isInterceptorEnabled(MethodInvocation invocation, Log logger) {
		return true;
	}
}