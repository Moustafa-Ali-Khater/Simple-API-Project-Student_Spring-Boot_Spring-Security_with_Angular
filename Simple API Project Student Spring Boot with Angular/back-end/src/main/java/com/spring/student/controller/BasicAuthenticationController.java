package com.spring.student.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
public class BasicAuthenticationController {

    @GetMapping("/basicauth")
    public String BasicAuthentication() {
        return "You are Authentication";
    }

    @GetMapping("/main")
    public String main() {
        return "Yes";
    }
}