package com.cyber.cozastore.controller;

import com.cyber.cozastore.payload.response.BaseResponse;
import com.cyber.cozastore.service.imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImp productServiceImp;

    @GetMapping("/category/{id}")
    public ResponseEntity<?> getProductByCategory(@PathVariable int id){

        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(productServiceImp.getProductByCategory(id));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable int id){

        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(productServiceImp.getProductById(id));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/category/all")
    public ResponseEntity<?> getAllProduct(){
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(productServiceImp.getAllProduct());

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
