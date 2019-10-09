package com.shiva.springboot.json;

public class JokeResponse {
	private String type;
	private JokeResponseValue value;

	public JokeResponseValue getValue() {
		return value;
	}

	public void setValue(JokeResponseValue value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
