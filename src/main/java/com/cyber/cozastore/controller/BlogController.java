package com.cyber.cozastore.controller;

import com.cyber.cozastore.payload.response.BaseResponse;
import com.cyber.cozastore.payload.response.BlogResponse;
import com.cyber.cozastore.service.imp.BlogServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
@CrossOrigin("*")
public class BlogController {

    @Autowired
    private BlogServiceImp blogServiceImp;

    @GetMapping("")
    public ResponseEntity<?> getAllBlog() {
        List<BlogResponse> list = blogServiceImp.getAllBlog();
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(list);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBlogById(@PathVariable int id) {
        BlogResponse data = blogServiceImp.getBlogById(id);
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(data);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
