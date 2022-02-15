package com.example.magazine.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("subscription")
public class SubscriptionController {
    @GetMapping("subscribe")
    public void subscribe() {

    }

    @GetMapping("unsubscribe")
    public void unsubscribe() {

    }
}
