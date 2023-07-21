package com.cyber.cozastore.service;

import com.cyber.cozastore.entity.SizeEntity;
import com.cyber.cozastore.payload.response.SizeResponse;
import com.cyber.cozastore.repository.SizeRepository;
import com.cyber.cozastore.service.imp.SizeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SizeService implements SizeServiceImp {

    @Autowired
    private SizeRepository sizeRepository;

    @Override
    public List<SizeResponse> getAllSize() {
        List<SizeEntity> list = sizeRepository.findAll();
        List<SizeResponse> responseList = new ArrayList<>();

        for (SizeEntity data: list) {
            SizeResponse sizeResponse = new SizeResponse();
            sizeResponse.setId(data.getId());
            sizeResponse.setName(data.getName());

            responseList.add(sizeResponse);
        }

        return responseList;
    }
}
