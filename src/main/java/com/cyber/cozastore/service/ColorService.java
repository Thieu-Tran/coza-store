package com.cyber.cozastore.service;

import com.cyber.cozastore.entity.ColorEntity;
import com.cyber.cozastore.payload.response.ColorResponse;
import com.cyber.cozastore.repository.ColorRepository;
import com.cyber.cozastore.service.imp.ColorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColorService implements ColorServiceImp {

    @Autowired
    private ColorRepository colorRepository;

    @Override
    public List<ColorResponse> getAllColor() {
        List<ColorEntity> list = colorRepository.findAll();
        List<ColorResponse> responseList = new ArrayList<>();

        for (ColorEntity data :list) {
            ColorResponse response = new ColorResponse();
            response.setId(data.getId());
            response.setName(data.getName());

            responseList.add(response);
        }

        return responseList;
    }

    @Override
    public List<ColorResponse> getColorByProductName(String name) {
        List<ColorEntity> list = colorRepository.getColorByProductName(name);
        List<ColorResponse> responseList = new ArrayList<>();

        for (ColorEntity data :list) {
            ColorResponse response = new ColorResponse();
            response.setId(data.getId());
            response.setName(data.getName());

            responseList.add(response);
        }

        return responseList;
    }


}
