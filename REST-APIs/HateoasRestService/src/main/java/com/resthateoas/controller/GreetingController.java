package com.resthateoas.controller;

import com.resthateoas.model.Greeting;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";


    @GetMapping("/greeting")
    public ResponseEntity<Greeting> greeting(@RequestParam(defaultValue = "World") String name){
        Greeting greeting = new Greeting(String.format(TEMPLATE,name));
        greeting.add(
                linkTo(
                        methodOn(GreetingController.class).greeting(name)
                ).withSelfRel());
        return ResponseEntity.status(HttpStatus.OK).body(greeting);
    }
}
