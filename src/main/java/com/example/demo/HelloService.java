package com.example.demo;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class HelloService {
    public Mono<String> greet() {
        return Mono.just("hello");
    }
}
