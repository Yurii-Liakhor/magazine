package com.example.magazine.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/subscription")
public class SubscriptionController {
    @GetMapping("/subscribe")
    public String subscribe() {
        log.info("subscribe");
        return "subscribe";
    }

    @GetMapping("/unsubscribe")
    public String unsubscribe() {
        log.info("unsubscribe");
        return "unsubscribe";
    }
}
