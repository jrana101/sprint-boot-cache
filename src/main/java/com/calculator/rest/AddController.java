package com.calculator.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class responsible for calculating a sum of one, two or three numbers
 * 
 * @author Volodymyr
 */
@RestController
public class AddController {

	private static final Logger log = LoggerFactory.getLogger(AddController.class);

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {

		log.debug("No parametrs in the request");
		return "Please add parametrs to the request";

	}

	@RequestMapping(value = "/add/{a}", method = RequestMethod.GET)
	@Cacheable(value = "addCache", key = "#a")
	public Double add(@PathVariable Double a) {

		log.debug("Parametrs: " + a);
		return a;

	}

	@RequestMapping(value = "/add/{a}/{b}", method = RequestMethod.GET)
	@Cacheable(value = "addCache", key = "#a.toString().concat('+').concat(#b.toString())")
	public Double add(@PathVariable Double a, @PathVariable Double b) {
		log.debug("Parametrs: " + a + ", " + b);
		Double result = a + b;
		return result;

	}

	@RequestMapping(value = "/add/{a}/{b}/{c}", method = RequestMethod.GET)
	@Cacheable(value = "addCache", key = "#a.toString().concat('+').concat(#b.toString()).concat('+').concat(#c.toString())")
	public Double add(@PathVariable Double a, @PathVariable Double b, @PathVariable Double c) {
		log.debug("Parametrs: " + a + ", " + b + ", " + c);
		Double result = a + b + c;
		return result;

	}

}