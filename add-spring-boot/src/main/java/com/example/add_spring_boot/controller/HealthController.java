package com.example.add_spring_boot.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/health")
public class HealthController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String healthTest() {
        return "Health status GOOD!!";
    }
}
