package com.demo;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.board.controller.BoardController;

public class SessionRegister implements HttpSessionListener {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Override
	public void sessionCreated(HttpSessionEvent evt) {
		logger.info("session created: " + evt.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent evt) {
		logger.info("session destroy ");
	}

}
