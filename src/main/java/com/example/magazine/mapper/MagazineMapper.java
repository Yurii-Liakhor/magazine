package com.example.magazine.mapper;

import com.example.magazine.dto.MagazineDto;
import com.example.magazine.entity.Magazine;

public class MagazineMapper {
    public MagazineDto toDto(Magazine entity) {
        return MagazineDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .build();
    }

    public Magazine toEntity(MagazineDto dto) {
        return Magazine.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .build();
    }
}
