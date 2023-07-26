package com.cyber.cozastore.controller;

import ch.qos.logback.core.net.HardenedObjectInputStream;
import com.cyber.cozastore.payload.response.BaseResponse;
import com.cyber.cozastore.payload.response.CountryResponse;
import com.cyber.cozastore.service.imp.CountryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
@CrossOrigin("*")
public class CountryController {

    @Autowired
    private CountryServiceImp countryServiceImp;

   @GetMapping("")
   public ResponseEntity<?> getAllCountry(){
       List<CountryResponse> list = countryServiceImp.getAllCountry();
       BaseResponse response = new BaseResponse();
       response.setStatusCode(200);
       response.setData(list);

       return new ResponseEntity<>(response, HttpStatus.OK);
   }

   @GetMapping("/{id}")
    public ResponseEntity<?> getCountryById(@PathVariable int id){
       CountryResponse data = countryServiceImp.getCountryById(id);
       BaseResponse response = new BaseResponse();

       response.setStatusCode(200);
       response.setData(data);

       return new ResponseEntity<>(response,HttpStatus.OK);
   }
}
