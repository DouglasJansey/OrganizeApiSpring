package com.organize.myorganize.service;

import com.organize.myorganize.dtos.UserDtos;
import com.organize.myorganize.model.UserModel;
import com.organize.myorganize.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public UserModel Save(UserDtos userDtos) {

        UserModel user = new UserModel();
        BeanUtils.copyProperties(userDtos, user);
        userRepository.save(user);
        return user;
    }

    public List<UserModel> findAll() {
        List<UserModel> userModelOptional = userRepository.findAll();
        return userModelOptional;
    }

    public Optional<UserModel> findOne(int phone) {
        Optional<UserModel> userModel = userRepository.findByPhone(phone);
        return userModel;
    }
}
