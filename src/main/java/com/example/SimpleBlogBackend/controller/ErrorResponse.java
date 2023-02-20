package com.example.SimpleBlogBackend.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private final LocalDateTime timeStamp = LocalDateTime.now();
}