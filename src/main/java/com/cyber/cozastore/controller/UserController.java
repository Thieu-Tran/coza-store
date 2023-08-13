package com.cyber.cozastore.controller;

import com.cyber.cozastore.payload.response.BaseResponse;
import com.cyber.cozastore.payload.response.UserResponse;
import com.cyber.cozastore.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserServiceImp userServiceImp;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id){
        UserResponse user = userServiceImp.getUserById(id);
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(user);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email){
        UserResponse user = userServiceImp.getUserByEmail(email);
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(user);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
