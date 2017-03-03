package com.spring.boot.api.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class RoutingFilter extends ZuulFilter {

	private static Logger logger = LoggerFactory.getLogger(RoutingFilter.class);

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		HttpServletResponse response = ctx.getResponse();

		logger.info(String.format("REQUEST :: < %s : %s : %s", request.getScheme(), request.getLocalAddr(),
				request.getLocalPort()));
		logger.info(String.format("REQUEST :: < %s : %s : %s", request.getMethod(), request.getRequestURI(),
				request.getProtocol()));
		logger.info(String.format("RESPONSE :: > HTTP : %s", response.getStatus()));

		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		return "routing";
	}

}
