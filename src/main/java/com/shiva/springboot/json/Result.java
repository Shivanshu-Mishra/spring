package com.shiva.springboot.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
@JsonProperty("formatted_address") //or define in application.properties which will convert all camelcase properties to underscore.
	private String formattedAddress;
	private Geometry geometry;

	public String getFormattedAddress() {
		return formattedAddress;
	}

	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}
}
