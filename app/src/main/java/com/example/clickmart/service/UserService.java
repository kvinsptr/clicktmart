package com.example.clickmart.service;

import com.example.clickmart.dto.UserDTO;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserService {
    @GET("users/riki")
    Call<UserDTO> getUser();
}
