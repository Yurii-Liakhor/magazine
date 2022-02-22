package com.example.magazine.model;

import com.example.magazine.entity.Magazine;
import lombok.Builder;

@lombok.Data
@Builder
public class Data {
    private Magazine[] magazines;
}
