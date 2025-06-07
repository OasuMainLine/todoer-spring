package com.todoer.todoer.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/")
    public ResponseEntity<Map<String, String>> index() {
        HashMap<String, String> response = new HashMap<>();
        response.put("message", "hello");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
