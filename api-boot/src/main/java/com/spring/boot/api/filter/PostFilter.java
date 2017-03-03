package com.spring.boot.api.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class PostFilter extends ZuulFilter {

	private static Logger logger = LoggerFactory.getLogger(PostFilter.class);

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		HttpServletResponse response = ctx.getResponse();
		logger.info(String.format("RESPONSE :: > %s : %s : %s : %s ===> HTTP:%s ", request.getMethod(),
				request.getScheme(), request.getRequestURI(), request.getLocalPort(), response.getStatus()));
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 1000;
	}

	@Override
	public String filterType() {
		return "post";
	}

}
