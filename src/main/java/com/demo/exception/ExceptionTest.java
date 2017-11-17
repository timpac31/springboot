package com.demo.exception;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionTest {

	@RequestMapping("error.do")
	public void ExceptionCreate() throws SQLException {
		throw new SQLException();
	}
	
	@RequestMapping("insertError.do")
	public void BoardSQLExceptionCreate() throws BoardSQLException {
		throw new BoardSQLException();
	}
}
