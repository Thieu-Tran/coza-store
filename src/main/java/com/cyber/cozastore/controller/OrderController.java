package com.cyber.cozastore.controller;

import com.cyber.cozastore.payload.request.OrderRequest;
import com.cyber.cozastore.payload.response.BaseResponse;
import com.cyber.cozastore.payload.response.OrderResponse;
import com.cyber.cozastore.service.imp.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private OrderServiceImp orderServiceImp;

    @PostMapping("")
    public ResponseEntity<?> addOrder(@Valid @RequestBody OrderRequest request){
        boolean isSuccess = orderServiceImp.addOrder(request);
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(isSuccess);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLastOrderByUserId(@PathVariable int id){
        OrderResponse order = orderServiceImp.getLastOrderByUserId(id);
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(order);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
