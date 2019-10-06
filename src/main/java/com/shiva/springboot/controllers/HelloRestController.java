package com.shiva.springboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shiva.springboot.entities.Greeting;

@RestController
public class HelloRestController {

	@GetMapping("/greet")
	public Greeting greet(@RequestParam(required = false,defaultValue = "World") String name) {
		return new Greeting(String.format("Hello %s", name));
	}

}
