package com.cyber.cozastore.service.imp;

import com.cyber.cozastore.payload.response.ColorResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ColorServiceImp {
    List<ColorResponse> getAllColor();
}
