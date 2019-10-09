package com.shiva.springboot.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shiva.springboot.services.JokeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JokeServiceTest {
	private Logger logger=LoggerFactory.getLogger(JokeServiceTest.class);
	@Autowired
	private JokeService jokeService;
	
	@Test
	public void testGetJokes() {
		assertNotNull(jokeService);
		String joke=jokeService.getJokes("Craig", "Walls");
		assertTrue(joke.contains("Craig")||joke.contains("Walls"));
	}

}
