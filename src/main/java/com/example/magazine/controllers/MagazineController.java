package com.example.magazine.controllers;

import com.example.magazine.dto.MagazineDto;
import com.example.magazine.mapper.MagazineMapper;
import com.example.magazine.repositories.MagazineRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/magazine")
@AllArgsConstructor
public class MagazineController {
    private final MagazineRepository magazineRepository;

    @GetMapping("/hello")
    public String hello() {
        log.info("hello");
        return "hello";
    }

    @PostMapping("/add")
    public void addMagazine(@RequestBody MagazineDto dto) {
        log.info("addMagazine");
        MagazineMapper magazineMapper = new MagazineMapper();
        magazineRepository.save(magazineMapper.toEntity(dto));
    }

    @PostMapping("/delete")
    public void deleteMagazine(@RequestBody MagazineDto dto) {
        log.info("deleteMagazine");
        MagazineMapper magazineMapper = new MagazineMapper();
        magazineRepository.delete(magazineMapper.toEntity(dto));
    }
}
