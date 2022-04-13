package com.baeldung.examples.reactive.services;

import java.time.Duration;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.baeldung.examples.reactive.ReactiveFooApplication;
import com.baeldung.examples.reactive.model.Foo;

import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ReactiveFooApplication.class)
public class FooServiceTest {
	@Autowired
	private FooService fooService;

	private Predicate<Foo> testFooPredicate = (foo) -> (foo.getId() == 1 && foo.getName().equals("Foo"));

	@Test
	public void when_request_all_foo_stream_results_at_interval() {
		StepVerifier.withVirtualTime(() -> fooService.streamFoo().take(2)).expectSubscription()
				.expectNoEvent(Duration.ofSeconds(1)).expectNextMatches(foo -> foo instanceof Foo)
				.thenAwait(Duration.ofSeconds(1)).expectNextMatches(testFooPredicate).thenAwait(Duration.ofSeconds(1))
				.verifyComplete();
	}
}
