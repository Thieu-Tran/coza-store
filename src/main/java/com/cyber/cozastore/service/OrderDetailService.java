package com.cyber.cozastore.service;

import com.cyber.cozastore.entity.OrderDetailEntity;
import com.cyber.cozastore.entity.ids.OrderDetailIds;
import com.cyber.cozastore.payload.request.OrderDetailRequest;
import com.cyber.cozastore.repository.OrderDetailRepository;
import com.cyber.cozastore.service.imp.OrderDetailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailService implements OrderDetailServiceImp {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public boolean addOrderDetail(List<OrderDetailRequest> requests) {
        boolean isSuccess = false;

        try {
            List<OrderDetailEntity> orderDetailEntityList = new ArrayList<>();
            for (OrderDetailRequest item : requests) {
                OrderDetailEntity orderDetail = new OrderDetailEntity();
                // Khởi tạo khóa chính
                OrderDetailIds orderDetailIds = new OrderDetailIds();

                // Set giá trị cho khóa chính
                orderDetailIds.setOrderId(item.getOrder().getId());
                orderDetailIds.setProductId(item.getProduct().getId());

                orderDetail.setIds(orderDetailIds);
                orderDetail.setQuantity(item.getQuantity());
                orderDetail.setPrice(item.getPrice());

                orderDetailEntityList.add(orderDetail);
            }
            orderDetailRepository.saveAll(orderDetailEntityList);
            isSuccess = true;

        }catch (Exception e){

        }
        return isSuccess;
    }
}
