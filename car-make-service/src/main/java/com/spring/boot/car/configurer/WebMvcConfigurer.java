package com.spring.boot.car.configurer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.spring.boot.car.interceptor.CustomInterceptor;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CustomInterceptor());
		super.addInterceptors(registry);
	}
}
