package com.cyber.cozastore.controller;

import com.cyber.cozastore.payload.request.OrderDetailRequest;
import com.cyber.cozastore.payload.response.BaseResponse;
import com.cyber.cozastore.service.imp.OrderDetailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/orderDetail")
@CrossOrigin("*")
public class OrderDetailController {

    @Autowired
    private OrderDetailServiceImp orderDetailServiceImp;

    @PostMapping("")
    public ResponseEntity<?> addOrderDetail(@Valid @RequestBody List<OrderDetailRequest> requests){
        boolean isSuccess = orderDetailServiceImp.addOrderDetail(requests);
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(isSuccess);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
