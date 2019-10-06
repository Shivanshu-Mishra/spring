package com.shiva.springboot.entities;

import java.util.Objects;

public class Greeting {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Greeting() {
	}

	public Greeting(String Message) {
		this.message = Message;
	}

}
