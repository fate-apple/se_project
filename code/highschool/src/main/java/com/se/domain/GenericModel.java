package com.se.domain;

import org.springframework.data.annotation.Id;

public class GenericModel {
	@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
