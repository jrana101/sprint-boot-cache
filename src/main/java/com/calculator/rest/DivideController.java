package com.calculator.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class responsible for calculating division of one, two or three numbers
 * 
 * @author Volodymyr
 */
@RestController
public class DivideController {

	private static final Logger log = LoggerFactory.getLogger(DivideController.class);

	@RequestMapping(value = "/divide", method = RequestMethod.GET)
	public String divide() {

		log.debug("No parametrs in the request");
		return "Please add parametrs to the request";

	}

	@RequestMapping(value = "/divide/{a}", method = RequestMethod.GET)
	@Cacheable(value = "divideCache", key = "#a")
	public Double divide(@PathVariable Double a) {

		log.debug("Parametrs: " + a);
		return a;

	}

	@RequestMapping(value = "/divide/{a}/{b}", method = RequestMethod.GET)
	@Cacheable(value = "divideCache", key = "#a.toString().concat(':').concat(#b.toString())")
	public Double divide(@PathVariable Double a, @PathVariable Double b) {
		log.debug("Parametrs: " + a + ", " + b);
		Double result = 0.0;
		if (b != 0) {
			result = a / b;

		}

		return result;

	}

	@Cacheable(value = "divideCache", key = "#a.toString().concat(':').concat(#b.toString()).concat(':').concat(#c.toString())")
	public Double divide(@PathVariable Double a, @PathVariable Double b, @PathVariable Double c) {
		log.debug("Parametrs: " + a + ", " + b + ", " + c);
		Double result = 0.0;
		if (b != 0 && c != 0) {
			result = a / b / c;

		}

		return result;

	}

}