package com.demo.learningtest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {
	private static final Logger logger = LoggerFactory.getLogger(TestAspect.class);
	
	@Before("execution(* com.demo.board.service.*.select*(..))")
	public void onBeforeHandler(JoinPoint joinPoint) {
		logger.info("TestAspect @before : " + joinPoint);
	}
	
	@After("execution(* com.demo.board.service.BoardService.select*(..))")
	public void onAfterHandler(JoinPoint joinPoint) {
		logger.info("TestAspect @after : " + joinPoint);
	}
	
	@AfterReturning(pointcut = "execution(* com.demo.board.service.*.*List(..))", returning = "str")
	public void onAfterReturningHandler(JoinPoint joinPoint, Object str) {
		logger.info("TestAspect @AfterReturning : " + joinPoint);
		logger.info("return: " + str);
	}
	
	@Pointcut("execution(* com.demo.board.service.*.*(..))")
	public void onPointcut() {
	}
	
	
}
