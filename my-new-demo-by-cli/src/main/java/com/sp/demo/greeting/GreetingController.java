package com.sp.demo.greeting;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@PostMapping("/greeting/v2")
	public ResponseEntity<String> greeting(@RequestBody GreetingRequest request) {
		String message = request.getGreeting()
				.concat(" - ").concat(request.getName().toUpperCase())
				.concat(" - ").concat(request.getMessage());
		return ResponseEntity.ok(message);
	}

}
