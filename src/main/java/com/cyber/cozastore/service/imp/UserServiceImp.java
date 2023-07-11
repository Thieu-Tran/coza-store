package com.cyber.cozastore.service.imp;

import com.cyber.cozastore.payload.request.SignupRequest;

public interface UserServiceImp {
    boolean addUser(SignupRequest request);
}
