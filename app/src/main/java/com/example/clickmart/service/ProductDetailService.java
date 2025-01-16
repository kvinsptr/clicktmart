package com.example.clickmart.service;

import com.example.clickmart.dto.ProductDetailDTO;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductDetailService {
    @GET("product")
    Call<ProductDetailDTO> getProductDetail();
}
