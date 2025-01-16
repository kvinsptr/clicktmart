package com.example.clickmart.dto;

public class SignInRequestDTO {
    private String username;
    private String password;

    public SignInRequestDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
