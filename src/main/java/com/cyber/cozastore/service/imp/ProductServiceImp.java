package com.cyber.cozastore.service.imp;

import com.cyber.cozastore.payload.response.ProductResponse;

import java.util.List;

public interface ProductServiceImp {
    List<ProductResponse> getProductByCategory(int id);

    List<ProductResponse> getAllProduct();

    ProductResponse getProductById(int id);
}
