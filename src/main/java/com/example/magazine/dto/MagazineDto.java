package com.example.magazine.dto;

import com.example.magazine.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
