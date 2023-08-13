package com.cyber.cozastore.service;

import com.cyber.cozastore.entity.OrderEntity;
import com.cyber.cozastore.payload.request.OrderRequest;
import com.cyber.cozastore.payload.response.OrderResponse;
import com.cyber.cozastore.repository.OrderRepository;
import com.cyber.cozastore.service.imp.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements OrderServiceImp {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public boolean addOrder(OrderRequest request) {
        boolean isSuccess = false;

        try {
            OrderEntity order = new OrderEntity();

            order.setUser(request.getUser());
            order.setCountry(request.getCountry());

            orderRepository.save(order);
            isSuccess=true;
        }catch (Exception e){

        }

        return isSuccess;
    }

    @Override
    public OrderResponse getLastOrderByUserId(int id) {
        OrderEntity order = orderRepository.getLastOrderByUserId(id);
        OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        response.setCreateDate(order.getDate());
        response.setUserId(order.getUser().getId());
        response.setCountryId(order.getCountry().getId());

        return response;
    }


}
