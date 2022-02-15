package com.example.magazine;

import com.example.magazine.entity.Magazine;
import com.example.magazine.repositories.MagazineRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Component
@AllArgsConstructor
public class AppLifecycle {
    MagazineRepository magazineRepository;

    @PostConstruct
    private void init() {
        log.info("init()");

//        Magazine magazine = Magazine.builder()
//                .title("Second magazine")
//                .description("My second magazine")
//                .price(2.5D)
//                .build();
//
//        magazineRepository.save(magazine);
    }

    @PreDestroy
    private void destroy() {
        log.info("destroy");
    }
}
