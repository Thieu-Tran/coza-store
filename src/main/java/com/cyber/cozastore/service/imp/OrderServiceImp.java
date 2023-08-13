package com.cyber.cozastore.service.imp;

import com.cyber.cozastore.payload.request.OrderRequest;
import com.cyber.cozastore.payload.response.OrderResponse;
import org.springframework.stereotype.Service;

@Service
public interface OrderServiceImp {
    boolean addOrder(OrderRequest request);
    OrderResponse getLastOrderByUserId(int id);
}
