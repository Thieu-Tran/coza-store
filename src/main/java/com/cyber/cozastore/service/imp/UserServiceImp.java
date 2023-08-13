package com.cyber.cozastore.service.imp;

import com.cyber.cozastore.payload.request.SignupRequest;
import com.cyber.cozastore.payload.response.UserResponse;

public interface UserServiceImp {
    boolean addUser(SignupRequest request);
    UserResponse getUserById(int id);
    UserResponse getUserByEmail(String email);
}
