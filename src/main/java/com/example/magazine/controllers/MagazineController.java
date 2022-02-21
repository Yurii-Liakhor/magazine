package com.example.magazine.controllers;

import com.example.magazine.dto.MagazineDto;
import com.example.magazine.mapper.MagazineMapper;
import com.example.magazine.model.Response;
import com.example.magazine.model.Status;
import com.example.magazine.repositories.MagazineRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/magazine")
@AllArgsConstructor
public class MagazineController {
    private final MagazineRepository magazineRepository;
    private final MagazineMapper magazineMapper = new MagazineMapper();

    @GetMapping("/test")
    public String test() {
        log.info("test");
        return "test";
    }

    @PostMapping("/add")
    public Response addMagazine(@RequestBody MagazineDto dto) {
        log.info("addMagazine");
        magazineRepository.save(magazineMapper.toEntity(dto));
        return Response.builder().status(Status.done).build();
    }

    @PostMapping("/delete")
    public Response deleteMagazine(@RequestBody MagazineDto dto) {
        log.info("deleteMagazine");
        magazineRepository.delete(magazineMapper.toEntity(dto));
        return Response.builder().status(Status.done).build();
    }
}
