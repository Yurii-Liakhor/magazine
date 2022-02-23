package com.example.magazine.controllers;

import com.example.magazine.entity.User;
import com.example.magazine.repositories.UserRepository;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/")
@AllArgsConstructor
public class SecurityController {
    private final Gson gson = new Gson();
    private final UserRepository userRepository;

    @GetMapping("/hello")
    public @ResponseBody String hello() {
        log.info("hello");
        return "hello";
    }

    @GetMapping( "/userLogin")
    public @ResponseBody String currentUserLogin(Principal principal) {
        return principal.getName();
    }

    @GetMapping("/registration")
    public String registration() {
        log.info("registration");
        return "registration.html";
    }

    @PostMapping("/register")
    public String register(HttpServletRequest request) {
        log.info("register");
        User user = new User();
        user.setLogin(request.getParameter("login"));
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        user.setAuthority("ROLE_USER");

        if(userRepository.existsUserByLogin(user.getLogin())) {
            return "redirect:registration.html";
        }
        userRepository.save(user);
        return "redirect:login";
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
