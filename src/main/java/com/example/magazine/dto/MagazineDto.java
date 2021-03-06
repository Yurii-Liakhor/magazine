package com.example.magazine.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MagazineDto {
    private Long id;
    private String title;
    private String description;
    private Double price;
}
