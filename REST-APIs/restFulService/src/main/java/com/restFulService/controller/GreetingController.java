package com.restFulService.controller;

import com.restFulService.model.Greeting;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private final AtomicLong countId = new AtomicLong();

    @GetMapping("/greeting") // expecting a name query param
    public ResponseEntity<Greeting> sendGreeting(@RequestParam(required = false) String name){
        String greetName = name == null ? "World" : name;

        return ResponseEntity.status(HttpStatus.OK).body(new Greeting(countId.incrementAndGet(), "Hello "+greetName + "!"));
    }
}
