package com.example.magazine.controllers;

import com.example.magazine.entity.Magazine;
import com.example.magazine.entity.User;
import com.example.magazine.model.Response;
import com.example.magazine.model.Status;
import com.example.magazine.repositories.MagazineRepository;
import com.example.magazine.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Slf4j
@RestController
@RequestMapping("/subscription")
@AllArgsConstructor
public class SubscriptionController {
    UserRepository userRepository;
    MagazineRepository magazineRepository;

    @GetMapping("/test")
    public String test() {
        log.info("test");
        return "test";
    }

    @GetMapping("/subscribe/{id}")
    public Response subscribe(Principal principal, @PathVariable Long id) {
        log.info("subscribe");
        User user = userRepository.findUserByLogin(principal.getName());
        Magazine magazine = magazineRepository.findMagazineById(id);
        user.addMagazine(magazine);
        userRepository.save(user);
        return Response.builder().status(Status.done).build();
    }

    @GetMapping("/unsubscribe/{id}")
    public Response unsubscribe(Principal principal, @PathVariable Long id) {
        log.info("unsubscribe");
        User user = userRepository.findUserByLogin(principal.getName());
        Magazine magazine = magazineRepository.findMagazineById(id);
        user.removeMagazine(magazine);
        userRepository.save(user);
        return Response.builder().status(Status.done).build();
    }
}
