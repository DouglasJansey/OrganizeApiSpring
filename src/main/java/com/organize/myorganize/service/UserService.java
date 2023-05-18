package com.organize.myorganize.service;

import com.organize.myorganize.model.UserModel;
import com.organize.myorganize.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public UserModel Save(UserModel userModel) {

        UserModel existUser = userRepository.findByEmail(userModel.getEmail());
        if(existUser != null){
            throw new Error("Usuário já existe");
        }
        return userRepository.save(userModel);
    }
}
