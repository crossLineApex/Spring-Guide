package com.restFulService.model;

// a record representation class
public record Greeting(long id, String content) {

    public void print(){
        System.out.println(id + " "+ content);
    }
}