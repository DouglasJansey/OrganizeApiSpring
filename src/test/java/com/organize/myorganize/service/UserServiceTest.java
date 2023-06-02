package com.organize.myorganize.service;

import com.organize.myorganize.dtos.UserDtos;
import com.organize.myorganize.model.UserModel;
import com.organize.myorganize.repository.UserRepository;
import com.organize.myorganize.service.UserService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;


@SuppressWarnings("ALL")
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @TestConfiguration
    static class userServiceConfigurationTest {
        @Bean
        public UserService userService(){
            return new UserService();
        }
    }
    @Autowired
    UserService userService;
    @MockBean
    UserRepository userRepository;

    @Test
    public void save() {
        UserDtos userDtos = new UserDtos();
        userDtos.setName("Douglas");
        userDtos.setEmail("Douglas.jansey@gmail.com");
        userDtos.setPassword("123456");

        UserModel userModel = new UserModel();
        userModel.setName(userDtos.getName());
        userModel.setEmail(userDtos.getEmail());
        userModel.setPassword(userDtos.getPassword());
        userModel.setId(UUID.randomUUID());



        Mockito.when(userRepository.save(Mockito.any()))
                .thenReturn(userModel);

       UserModel newUser = userService.Save(userDtos);

        Assert.assertNotNull(newUser.getId());
    }
}