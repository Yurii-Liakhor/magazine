package com.example.magazine.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Slf4j
@RestController
@RequestMapping("/")
public class SecurityController {

    @GetMapping("/hello")
    public String hello() {
        log.info("hello");
        return "hello";
    }

    @GetMapping( "/userLogin")
    @ResponseBody
    public String currentUserLogin(Principal principal) {
        return principal.getName();
    }

//    @GetMapping("/auth")
//    public String auth() {
//        log.info("auth");
//        return "auth";
//    }

//    @GetMapping("/login")
//    public String login() {
//        log.info("login");
//        return "login";
//    }
}
