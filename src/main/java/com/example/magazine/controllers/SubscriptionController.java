package com.example.magazine.controllers;

import com.example.magazine.entity.Magazine;
import com.example.magazine.entity.User;
import com.example.magazine.model.Data;
import com.example.magazine.model.Response;
import com.example.magazine.model.Status;
import com.example.magazine.repositories.MagazineRepository;
import com.example.magazine.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Set;

@Slf4j
@Controller
@RequestMapping("/subscription")
@AllArgsConstructor
public class SubscriptionController {
    private final UserRepository userRepository;
    private final MagazineRepository magazineRepository;

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        log.info("test");
        return "test";
    }

    @GetMapping("/all")
    @ResponseBody
    public Response allSubscription(Principal principal) {
        log.info("allSubscription");
        User user = userRepository.findUserByLogin(principal.getName());
        Set<Magazine> magazines = user.getMagazines();

        return Response.builder()
                .status(Status.done)
                .data(Data.builder()
                        .magazines(magazines.toArray(Magazine[]::new))
                        .build())
                .build();
    }

    @GetMapping("/subscribe/{id}")
    public String subscribe(Principal principal, @PathVariable Long id) {
        log.info("subscribe");
        User user = userRepository.findUserByLogin(principal.getName());
        Magazine magazine = magazineRepository.findMagazineById(id);
        user.addMagazine(magazine);
        userRepository.save(user);
        return "redirect:http://localhost:8099/subscription.html";
    }

    @GetMapping("/unsubscribe/{id}")
    public String unsubscribe(Principal principal, @PathVariable Long id) {
        log.info("unsubscribe");
        User user = userRepository.findUserByLogin(principal.getName());
        Magazine magazine = magazineRepository.findMagazineById(id);
        user.removeMagazine(magazine);
        userRepository.save(user);
        return "redirect:http://localhost:8099/subscription.html";
    }

//    @GetMapping("/subscribe/{id}")
//    public Response subscribe(Principal principal, @PathVariable Long id) {
//        log.info("subscribe");
//        User user = userRepository.findUserByLogin(principal.getName());
//        Magazine magazine = magazineRepository.findMagazineById(id);
//        user.addMagazine(magazine);
//        userRepository.save(user);
//        return Response.builder().status(Status.done).build();
//    }
//
//    @GetMapping("/unsubscribe/{id}")
//    public Response unsubscribe(Principal principal, @PathVariable Long id) {
//        log.info("unsubscribe");
//        User user = userRepository.findUserByLogin(principal.getName());
//        Magazine magazine = magazineRepository.findMagazineById(id);
//        user.removeMagazine(magazine);
//        userRepository.save(user);
//        return Response.builder().status(Status.done).build();
//    }
}
