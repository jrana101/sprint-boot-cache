package com.calculator.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class responsible for calculating s subtraction of one, two or three numbers
 * 
 * @author Volodymyr
 */
@RestController
public class SubstractController {

	private static final Logger log = LoggerFactory.getLogger(SubstractController.class);

	@RequestMapping(value = "/substract", method = RequestMethod.GET)
	public String substract() {

		log.debug("No parametrs in the request");
		return "Please add parametrs to the request";
	}

	@RequestMapping(value = "/substract/{a}", method = RequestMethod.GET)
	@Cacheable(value = "substractCache", key = "#a")
	public Double substract(@PathVariable Double a) {

		log.debug("Parametrs: " + a);
		return a;

	}

	@RequestMapping(value = "/substract/{a}/{b}", method = RequestMethod.GET)
	@Cacheable(value = "substractCache", key = "#a.toString().concat('+').concat(#b.toString())")
	public Double substract(@PathVariable Double a, @PathVariable Double b) {
		log.debug("Parametrs: " + a + ", " + b);
		Double result = a - b;
		return result;

	}

	@RequestMapping(value = "/substract/{a}/{b}/{c}", method = RequestMethod.GET)
	@Cacheable(value = "substractCache", key = "#a.toString().concat('+').concat(#b.toString()).concat('+').concat(#c.toString())")
	public Double substract(@PathVariable Double a, @PathVariable Double b, @PathVariable Double c) {
		log.debug("Parametrs: " + a + ", " + b + ", " + c);
		Double result = a - b - c;
		return result;

	}

}