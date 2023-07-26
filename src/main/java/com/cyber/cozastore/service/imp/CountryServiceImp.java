package com.cyber.cozastore.service.imp;

import com.cyber.cozastore.payload.response.CountryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CountryServiceImp {
    List<CountryResponse> getAllCountry();
    CountryResponse getCountryById(int id);
}
