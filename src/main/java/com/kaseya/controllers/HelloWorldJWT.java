package com.kaseya.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldJWT {
    @GetMapping
    public ResponseEntity<String> firstPage() {
        return new ResponseEntity<String>("This is a String", HttpStatus.OK);
    }
}
