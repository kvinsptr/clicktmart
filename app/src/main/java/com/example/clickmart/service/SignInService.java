package com.example.clickmart.service;
import com.example.clickmart.dto.SignInRequestDTO;
import com.example.clickmart.dto.SignInResponseDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SignInService {
    @POST("signin/validate")
    Call<SignInResponseDTO> login(@Body SignInRequestDTO request);
}
