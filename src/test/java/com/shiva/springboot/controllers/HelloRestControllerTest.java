package com.shiva.springboot.controllers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.shiva.springboot.entities.Greeting;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloRestControllerTest {

	@Autowired
	private TestRestTemplate template;

	@Test
	public void greetWithoutName() {
		ResponseEntity<Greeting> entity = template.getForEntity("/greet", Greeting.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		assertEquals(MediaType.APPLICATION_JSON_UTF8, entity.getHeaders().getContentType());
		Greeting response = entity.getBody();
		assertEquals("Hello World", response.getMessage());
	}

	@Test
	public void greet() {
		Greeting response = template.getForObject("/greet?name=Shiva", Greeting.class);
		assertEquals("Hello Shiva", response.getMessage());
	}
}
