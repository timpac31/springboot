package com.demo.exception;

import java.sql.SQLException;

import javax.naming.SizeLimitExceededException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.demo.util.StringUtil;

@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	private static final String DEFAULT_ERROR_VIEW = "common/error";
	private static final String REDIRECT_ERROR_VIEW = "redirect";
	
	@ExceptionHandler(SQLException.class)
	public ModelAndView handleSQLException(HttpServletRequest request, Exception ex) throws Exception {
		logger.info(request.getRequestURL() + " : " + "SQLException occur!!");
		ex.printStackTrace();
	
	    if (AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class) != null)
			throw ex;

	    ModelAndView mav = new ModelAndView();
	    mav.addObject("error", ex);
	    mav.addObject("massage", "DB 처리 중  오류가 발생했습니다.");
	    mav.setViewName(DEFAULT_ERROR_VIEW);
	    return mav;
	}
	
	@ExceptionHandler(BoardSQLException.class)
	public ModelAndView handleBoardSQLException(HttpServletRequest request, Exception ex) throws Exception {
		if (AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class) != null)
			throw ex;
		
		logger.info(request.getRequestURL() + " BoardSQLException: " + ex.getMessage());
		ex.printStackTrace();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "등록에 실패했습니다.");
	    mav.addObject("url", "/board/list.do");
		mav.setViewName(REDIRECT_ERROR_VIEW);
		return mav;
	}
	
	@ExceptionHandler(InvalidFileException.class)
	public ModelAndView handleInvalidFileException(HttpServletRequest request, Exception ex) throws Exception {
		logger.info(request.getRequestURL() + " InvalidFileException: " + ex);
		ex.printStackTrace();
		
		String referer = StringUtil.nvl(request.getHeader("Referer"), "/board/list.do");
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", ex.getMessage());
	    mav.addObject("url", referer);
		mav.setViewName(REDIRECT_ERROR_VIEW);
		return mav;
	}
	
	@ExceptionHandler(SizeLimitExceededException.class)
	public ModelAndView HandleFileUploadException(HttpServletRequest request, Exception ex) throws Exception {
		logger.info(request.getRequestURL() + " FileUploadException: " + ex);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("error", ex);
	    mav.addObject("url", "file upload error");
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;
	}
	
	
}


