package com.cyber.cozastore.service.imp;

import com.cyber.cozastore.payload.response.SizeResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SizeServiceImp {
    List<SizeResponse> getAllSize();
}
