package com.cyber.cozastore.service.imp;

import com.cyber.cozastore.payload.response.BannerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BannerServiceImp {
    List<BannerResponse> getAllBanner();
}
