package com.demo.exception;

public class InvalidFileException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InvalidFileException() {
		super();
	}
	public InvalidFileException(String msg) {
		super(msg);
	}
	public InvalidFileException(Throwable e) {
		super(e);
	}
	
}
