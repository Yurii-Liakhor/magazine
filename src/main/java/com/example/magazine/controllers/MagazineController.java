package com.example.magazine.controllers;

import com.example.magazine.dto.MagazineDto;
import com.example.magazine.entity.Magazine;
import com.example.magazine.entity.User;
import com.example.magazine.mapper.MagazineMapper;
import com.example.magazine.model.Data;
import com.example.magazine.model.Response;
import com.example.magazine.model.Status;
import com.example.magazine.repositories.MagazineRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/magazine")
@AllArgsConstructor
public class MagazineController {
    private final MagazineRepository magazineRepository;
    private final MagazineMapper magazineMapper = new MagazineMapper();

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        log.info("test");
        return "test";
    }

    @GetMapping("/all")
    @ResponseBody
    public Response allMagazines() {
        log.info("allMagazines");
        List<Magazine> magazineList = magazineRepository.findAll();
        return Response.builder()
                .status(Status.done)
                .data(Data.builder()
                        .magazines(magazineList.toArray(new Magazine[0]))
                        .build())
                .build();
    }

    @PostMapping("/add")
    public String addMagazine(HttpServletRequest request) {
        log.info("addMagazine");
        Magazine magazine = new Magazine();
        magazine.setTitle(request.getParameter("title"));
        magazine.setDescription(request.getParameter("description"));
        magazine.setPrice(Double.valueOf(request.getParameter("price")));
        magazineRepository.save(magazine);

        return "redirect:../magazine.html";
    }

    @PostMapping("/delete")
    public String deleteMagazine(HttpServletRequest request) {
        log.info("deleteMagazine");
        Long id = Long.valueOf(request.getParameter("id"));
        magazineRepository.deleteById(id);

        return "redirect:../magazine.html";
    }

//    @PostMapping("/add")
//    public Response addMagazine(@RequestBody MagazineDto dto) {
//        log.info("addMagazine");
//        magazineRepository.save(magazineMapper.toEntity(dto));
//        return Response.builder().status(Status.done).build();
//    }
//
//    @PostMapping("/delete")
//    public Response deleteMagazine(@RequestBody MagazineDto dto) {
//        log.info("deleteMagazine");
//        magazineRepository.deleteById(dto.getId());
//        return Response.builder().status(Status.done).build();
//    }
}
