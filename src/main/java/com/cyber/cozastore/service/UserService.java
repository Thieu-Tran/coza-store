package com.cyber.cozastore.service;

import com.cyber.cozastore.entity.UserEntity;
import com.cyber.cozastore.payload.request.SignupRequest;
import com.cyber.cozastore.payload.response.UserResponse;
import com.cyber.cozastore.repository.UserRepository;
import com.cyber.cozastore.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceImp {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean addUser(SignupRequest request) {
        boolean isSuccess = false;
        try {
            UserEntity user = new UserEntity();
            user.setUsername(request.getUsername());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setEmail(request.getEmail());

            userRepository.save(user);
            isSuccess = true;
        }catch (Exception e){

        }

        return isSuccess;
    }

    @Override
    public UserResponse getUserById(int id) {
        UserEntity user = userRepository.findById(id);
        UserResponse response = new UserResponse();

        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setPassword(user.getPassword());
        response.setEmail(user.getEmail());

        return response;
    }

    @Override
    public UserResponse getUserByEmail(String email) {
        UserResponse response = new UserResponse();

        try {
            UserEntity user = userRepository.findByEmail(email);

            response.setId(user.getId());
            response.setUsername(user.getUsername());
            response.setEmail(user.getEmail());
        }catch (Exception e){

        }

        return response;
    }


}
