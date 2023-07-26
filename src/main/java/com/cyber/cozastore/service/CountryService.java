package com.cyber.cozastore.service;

import com.cyber.cozastore.entity.CountryEntity;
import com.cyber.cozastore.payload.response.CountryResponse;
import com.cyber.cozastore.repository.CountryRepository;
import com.cyber.cozastore.service.imp.CountryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService implements CountryServiceImp {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<CountryResponse> getAllCountry() {
        List<CountryEntity> list =  countryRepository.findAll();
        List<CountryResponse> responseList = new ArrayList<>();

        for (CountryEntity data:list) {
            CountryResponse response = new CountryResponse();
            response.setId(data.getId());
            response.setName(data.getName());
            response.setPrice(data.getPriceShip());

            responseList.add(response);
        }

        return responseList;
    }

    @Override
    public CountryResponse getCountryById(int id) {
        CountryEntity data = countryRepository.findById(id);
        CountryResponse response = new CountryResponse();

        response.setId(data.getId());
        response.setName(data.getName());
        response.setPrice(data.getPriceShip());

        return response;
    }
}
