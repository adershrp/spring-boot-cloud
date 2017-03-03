package com.spring.boot.car.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.car.model.Greeting;

@RestController
public class CarMakeController {

	private Logger logger = Logger.getLogger(CarMakeController.class);

	@Value("${message.template}")
	private String template;

	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value = "/greeting/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Greeting greeting(@PathVariable String name) {

		Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));
		logger.info("Response :: >> " + greeting);
		return greeting;
	}

	@RequestMapping(value = "/greeting", method = RequestMethod.GET, headers = "Accept=application/json")
	public Greeting greeting() {
		Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, "Dummy System Call"));
		logger.info("Response :: >> " + greeting);
		return greeting;
	}
}
