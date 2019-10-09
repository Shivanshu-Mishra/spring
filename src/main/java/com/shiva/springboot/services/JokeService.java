package com.shiva.springboot.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shiva.springboot.json.JokeResponse;

@Service
public class JokeService {

	private RestTemplate template;
	private static final String BASE_URL="http://api.icndb.com/jokes/random?firstName=&lastName=%s";
	
	public JokeService(RestTemplateBuilder builder) {
		this.template=builder.build();
	}
	
	public String getJokes(String firstName,String lastName) {
		String url=String.format(BASE_URL, firstName,lastName);
		JokeResponse response=template.getForObject(url, JokeResponse.class);
		return response.getValue().getJoke();
		
	}
	
	
}
