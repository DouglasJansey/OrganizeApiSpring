package com.organize.myorganize.service;

import com.organize.myorganize.dtos.UserDtos;
import com.organize.myorganize.model.UserModel;
import com.organize.myorganize.repository.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.UUID;


@SuppressWarnings("ALL")
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;
    @MockBean
    private UserRepository userRepository;

    @Test
    void save() {
        UserDtos userDtos = new UserDtos();
        userDtos.setName("Douglas");
        userDtos.setEmail("Douglas.jansey@gmail.com");
        userDtos.setPassword("123456");

        UserModel userModel = new UserModel();
        userModel.setName(userDtos.getName());
        userModel.setEmail(userDtos.getEmail());
        userModel.setPassword(userDtos.getPassword());
        userModel.setId(UUID.randomUUID());


        Mockito.when(userService.Save(userDtos))
                .thenReturn(userModel);

        UserModel userResponse = userService.Save(userDtos);

        Assert.assertNotNull(userResponse.getId());
    }
}