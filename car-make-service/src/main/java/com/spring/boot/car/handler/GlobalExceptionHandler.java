package com.spring.boot.car.handler;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	private Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(value = Throwable.class)
	public String handleException(Throwable e) {
		logger.error(e);
		return e.getMessage();
	}
}
