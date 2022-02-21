package com.example.magazine.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    private Status status;
}
