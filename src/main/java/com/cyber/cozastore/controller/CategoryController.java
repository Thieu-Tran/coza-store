package com.cyber.cozastore.controller;

import com.cyber.cozastore.payload.response.BaseResponse;
import com.cyber.cozastore.service.imp.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryServiceImp categoryServiceImp;

    @GetMapping("")
    public ResponseEntity<?> getAllCategory(){
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(categoryServiceImp.getAllCategory());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
