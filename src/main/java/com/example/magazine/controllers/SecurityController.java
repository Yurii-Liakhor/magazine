package com.example.magazine.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
    @GetMapping(name = "login")
    public void login() {

    }

    @GetMapping(name = "registration")
    public void registration() {

    }
}
