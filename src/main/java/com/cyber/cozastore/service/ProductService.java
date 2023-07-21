package com.cyber.cozastore.service;

import com.cyber.cozastore.entity.ProductEntity;
import com.cyber.cozastore.payload.response.ProductResponse;
import com.cyber.cozastore.repository.ProductRepository;
import com.cyber.cozastore.service.imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements ProductServiceImp {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductResponse> getProductByCategory(int id) {

        List<ProductEntity> list = productRepository.findByCategoryId(id);
        List<ProductResponse> responseList = new ArrayList<>();
        for (ProductEntity data:list) {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setId(data.getId());
            productResponse.setName(data.getName());
            productResponse.setImage(data.getImage());
            productResponse.setPrice(data.getPrice());

            responseList.add(productResponse);
        }

        return responseList;
    }

    @Override
    public List<ProductResponse> getAllProduct() {
        List<ProductEntity> list = productRepository.findAll();
        List<ProductResponse> responseList = new ArrayList<>();

        for (ProductEntity data: list) {
            ProductResponse productResponse = new ProductResponse();

            productResponse.setId(data.getId());
            productResponse.setName(data.getName());
            productResponse.setImage(data.getImage());
            productResponse.setPrice(data.getPrice());
            productResponse.setDescription(data.getDescription());
            productResponse.setQuantity(data.getQuantity());
            productResponse.setImageDetail(data.getImageDetail());
            productResponse.setCategoryId(data.getCategory().getId());

            responseList.add(productResponse);
        }

        return responseList;
    }

    @Override
    public ProductResponse getProductById(int id) {
        ProductEntity product = productRepository.findById(id);
        ProductResponse productResponse = new ProductResponse();

            productResponse.setId(product.getId());
            productResponse.setName(product.getName());
            productResponse.setImage(product.getImage());
            productResponse.setPrice(product.getPrice());
            productResponse.setDescription(product.getDescription());
            productResponse.setQuantity(product.getQuantity());
            productResponse.setImageDetail(product.getImageDetail());
            productResponse.setCategoryId(product.getCategory().getId());

        return productResponse;
    }
}
