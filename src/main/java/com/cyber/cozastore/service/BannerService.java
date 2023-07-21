package com.cyber.cozastore.service;

import com.cyber.cozastore.entity.BannerEntity;
import com.cyber.cozastore.payload.response.BannerResponse;
import com.cyber.cozastore.repository.BannerRepository;
import com.cyber.cozastore.service.imp.BannerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BannerService implements BannerServiceImp {

    @Autowired
    private BannerRepository bannerRepository;

    @Override
    public List<BannerResponse> getAllBanner() {
        List<BannerEntity> list = bannerRepository.findAll();
        List<BannerResponse> responseList = new ArrayList<>();

        for (BannerEntity data:list) {
            BannerResponse response = new BannerResponse();
            response.setId(data.getId());
            response.setName(data.getName());
            response.setContent(data.getContent());
            response.setImage(data.getImage());

            responseList.add(response);
        }


        return responseList;
    }
}
