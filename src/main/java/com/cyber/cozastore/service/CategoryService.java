package com.cyber.cozastore.service;

import com.cyber.cozastore.entity.CategoryEntity;
import com.cyber.cozastore.payload.response.CategoryResponse;
import com.cyber.cozastore.repository.CategoryRepository;
import com.cyber.cozastore.service.imp.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements CategoryServiceImp {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponse> getAllCategory() {
        List<CategoryEntity> list = categoryRepository.findAll();
        List<CategoryResponse> responseList = new ArrayList<>();

        for (CategoryEntity data: list) {
            CategoryResponse categoryResponse = new CategoryResponse();
            categoryResponse.setId(data.getId());
            categoryResponse.setName(data.getName());

            responseList.add(categoryResponse);
        }

        return responseList;
    }
}
