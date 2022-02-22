package com.example.magazine.model;

import lombok.Builder;

@lombok.Data
@Builder
public class Response {
    private Status status;
    private Data data;
}
