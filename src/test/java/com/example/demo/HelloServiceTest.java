package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;

class HelloServiceTest {

    private final HelloService helloService = new HelloService();

    @Test
    void greet() {
        helloService.greet().subscribe(s -> Assertions.assertThat(s).isEqualTo("hello"));
    }
}