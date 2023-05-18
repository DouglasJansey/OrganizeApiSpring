package com.organize.myorganize.controller;

import com.organize.myorganize.model.UserModel;
import com.organize.myorganize.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping
    public UserModel createUser(@RequestBody UserModel userModel){
        return userService.Save(userModel);
    }

}
