package com.example.clickmart.service;

import com.example.clickmart.dto.ProductDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
public interface ProductListService {
    @GET("product/list")
    Call<List<ProductDTO>> getProductList();
}
