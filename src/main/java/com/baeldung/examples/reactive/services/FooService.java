package com.baeldung.examples.reactive.services;

import java.time.Duration;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.baeldung.examples.reactive.model.Foo;

import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

@Service
public class FooService {
	private static final long STREAM_BACK_PRESSURE_TIME = 1L;

	private final Supplier<Foo> fooSupplier = () -> new Foo(1, "Foo");

	public Flux<Foo> streamFoo() {
		return Flux.zip(Flux.interval(Duration.ofSeconds(STREAM_BACK_PRESSURE_TIME)),
				Flux.fromStream(Stream.generate(fooSupplier))).map(Tuple2::getT2);
	}
}
