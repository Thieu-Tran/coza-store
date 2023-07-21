package com.cyber.cozastore.controller;

import com.cyber.cozastore.payload.response.BaseResponse;
import com.cyber.cozastore.payload.response.SizeResponse;
import com.cyber.cozastore.service.imp.SizeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/size")
@CrossOrigin("*")
public class SizeController {

    @Autowired
    private SizeServiceImp sizeServiceImp;

    @GetMapping("")
    public ResponseEntity<?> getAllSize(){
        List<SizeResponse> list = sizeServiceImp.getAllSize();
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(list);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
