package com.cyber.cozastore.controller;

import com.cyber.cozastore.payload.request.SignupRequest;
import com.cyber.cozastore.payload.response.BaseResponse;
import com.cyber.cozastore.service.imp.UserServiceImp;
import com.cyber.cozastore.utils.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
//@CrossOrigin("*")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private UserServiceImp userServiceImp;

    @RequestMapping(value = "/signin",method = RequestMethod.POST)
    public ResponseEntity<?> signin(@RequestParam String email,@RequestParam String password){

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email,password);
        authenticationManager.authenticate(token);

        String jwt = jwtHelper.generateToken(email);

        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(jwt);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public ResponseEntity<?> signin(@Valid SignupRequest request){

        boolean isSuccess = userServiceImp.addUser(request);

        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(isSuccess);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
