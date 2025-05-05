package com.spring.vote.controller;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
