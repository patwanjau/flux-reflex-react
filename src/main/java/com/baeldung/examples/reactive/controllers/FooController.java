package com.baeldung.examples.reactive.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.examples.reactive.model.Foo;
import com.baeldung.examples.reactive.services.FooService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/foos")
public class FooController {
	private final FooService fooService;

	public FooController(FooService fooService) {
		this.fooService = fooService;
	}

	@GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Foo> getAllFoo() {
		return fooService.streamFoo();
	}
}
