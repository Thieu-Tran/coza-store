package com.cyber.cozastore.controller;

import com.cyber.cozastore.payload.response.BaseResponse;
import com.cyber.cozastore.payload.response.TagResponse;
import com.cyber.cozastore.service.imp.TagServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
@CrossOrigin("*")
public class TagController {

    @Autowired
    private TagServiceImp tagServiceImp;

    @GetMapping("/{id}")
    public ResponseEntity<?> getTagByBlogId(@PathVariable int id){
        List<TagResponse> list = tagServiceImp.getTagByBlogId(id);
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(list);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllTag(){
        List<TagResponse> list = tagServiceImp.getAllTag();
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(list);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
