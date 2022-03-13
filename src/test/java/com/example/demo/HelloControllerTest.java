package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@WebFluxTest
class HelloControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private HelloService helloService;

    @BeforeEach
    void setup() {
        Mockito.when(helloService.greet())
                .thenReturn(Mono.just("hello"));
    }

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
