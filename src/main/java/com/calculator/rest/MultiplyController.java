package com.calculator.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class responsible for calculation a multiplication of one, two or three
 * numbers
 * 
 * @author Volodymyr
 */
@RestController
public class MultiplyController {

	private static final Logger log = LoggerFactory.getLogger(MultiplyController.class);

	@RequestMapping(value = "/multiply", method = RequestMethod.GET)
	public String multiply() {

		log.debug("No parametrs in the request");
		return "Please add parametrs to the request";

	}

	@RequestMapping(value = "/multiply/{a}", method = RequestMethod.GET)
	@Cacheable(value = "multiplyCache", key = "#a")
	public Double multiply(@PathVariable Double a) {

		log.debug("Parametrs: " + a);
		return a;

	}

	@RequestMapping(value = "/multiply/{a}/{b}", method = RequestMethod.GET)
	@Cacheable(value = "multiplyCache", key = "#a.toString().concat('*').concat(#b.toString())")
	public Double multiply(@PathVariable Double a, @PathVariable Double b) {
		log.debug("Parametrs: " + a + ", " + b);
		Double result = a * b;
		return result;

	}

	@RequestMapping(value = "/multiply/{a}/{b}/{c}", method = RequestMethod.GET)
	@Cacheable(value = "multiplyCache", key = "#a.toString().concat('*').concat(#b.toString()).concat('*').concat(#c.toString())")
	public Double multiply(@PathVariable Double a, @PathVariable Double b, @PathVariable Double c) {
		log.debug("Parametrs: " + a + ", " + b + ", " + c);
		Double result = a * b * c;
		return result;

	}

}