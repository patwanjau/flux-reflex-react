package com.baeldung.examples.reactive.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Foo {

	@JsonProperty("foo_id")
	private Integer id;
	private String name;

	public Foo() {
	}

	public Foo(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
