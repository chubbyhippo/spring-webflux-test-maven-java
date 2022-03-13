package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@AutoConfigureWebTestClient
class DemoApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void shouldReturnHello() {
		webTestClient.get()
				.uri("/hello")
				.exchange()
				.expectStatus()
				.is2xxSuccessful()
				.expectBody(String.class)
				.isEqualTo("hello");
	}

}
