package com.example.clickmart;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.clickmart.adapter.ProductDetailAdapter;
import com.example.clickmart.dto.ProductDetailDTO;
import com.example.clickmart.service.ProductDetailService;
import com.example.clickmart.R;
import com.google.android.material.button.MaterialButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailActivity extends AppCompatActivity {
    private TextView productTitle, productPrice, productRating, productDescription;
    private MaterialButton orderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.product_detail_view);

        // Bind views
        productTitle = findViewById(R.id.productTitle);
        productPrice = findViewById(R.id.productPrice);
        productRating = findViewById(R.id.productRating);
        productDescription = findViewById(R.id.productDescription);
        orderButton = findViewById(R.id.orderButton);

        // Load product details
        loadProductDetail();

        // Set up order button click
        orderButton.setOnClickListener(v -> {
            Toast.makeText(this, "Pesanan Anda telah diterima!", Toast.LENGTH_SHORT).show();
        });
    }

    private void loadProductDetail() {
        ProductDetailService productDetailService = ProductDetailAdapter.getRetrofitInstance().create(ProductDetailService.class);
        Call<ProductDetailDTO> call = productDetailService.getProductDetail();

        call.enqueue(new Callback<ProductDetailDTO>() {
            @Override
            public void onResponse(Call<ProductDetailDTO> call, Response<ProductDetailDTO> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ProductDetailDTO product = response.body();

                    // Set data to views
                    productTitle.setText(product.getName());
                    productPrice.setText(product.getPrice());
                    productDescription.setText(product.getDescription());

                    Log.d("ProductDetail", "Product loaded successfully.");
                } else {
                    Log.e("ProductDetail", "Failed to load product details.");
                    Toast.makeText(ProductDetailActivity.this, "Gagal memuat detail produk.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ProductDetailDTO> call, Throwable t) {
                Log.e("ProductDetail", "Error: " + t.getMessage());
                Toast.makeText(ProductDetailActivity.this, "Terjadi kesalahan saat memuat detail produk.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}