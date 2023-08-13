package com.cyber.cozastore.service.imp;

import com.cyber.cozastore.payload.request.OrderDetailRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDetailServiceImp {
    boolean addOrderDetail(List<OrderDetailRequest> requests);
}
