package com.spring.boot.car.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CustomInterceptor implements HandlerInterceptor {
	private static final String START_TIME = "startTime";
	private static final String REQUEST_URL = "Request URL::";
	private Logger logger = Logger.getLogger(CustomInterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception exception) throws Exception {
		long startTime = (Long) request.getAttribute(START_TIME);
		logger.info(REQUEST_URL + request.getRequestURL().toString() + ":: End Time = " + System.currentTimeMillis());
		logger.info(REQUEST_URL + request.getRequestURL().toString() + ":: Time Taken= "
				+ (System.currentTimeMillis() - startTime));
		if (null != exception)
			logger.info(REQUEST_URL + request.getRequestURL().toString() + ":: Exception "
					+ exception.getLocalizedMessage());

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView view)
			throws Exception {
		logger.info(REQUEST_URL + request.getRequestURL().toString() + " Sent to Handler :: Current Time = "
				+ System.currentTimeMillis());

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		long startTime = System.currentTimeMillis();
		logger.info(REQUEST_URL + request.getRequestURL().toString() + ":: Start Time = " + System.currentTimeMillis());
		request.setAttribute(START_TIME, startTime);
		return true;
	}

}
