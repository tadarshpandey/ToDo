package com.todo.start.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/userbasic")
public class UserBasicController {
    @GetMapping("/public")
    public String pulciEndpoint() {
        return "Hello, user! your are a public endpoint";
    }

    @GetMapping("/account")
    public String accountEndpoint(){
        return "Hello, user! Account endpoint";
    }
    @GetMapping("/admin")
    public String adminEndpoint(){
        return "Hello, user! Admin endpoint";
    }
    
}
