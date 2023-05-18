package com.organize.myorganize.ServiceTest;

import com.organize.myorganize.model.UserModel;
import com.organize.myorganize.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;


@SuppressWarnings("ALL")
@RunWith(SpringRunner.class)
public class UserServiceTeste {
    @Test
    public void createUserTeste(){
        UserModel userModel = new UserModel();
        userModel.setEmail("douglas.jansey@gmail.com");
        userModel.setName("Douglas");
        userModel.setPassword("123456789");

        UserService userService = new UserService();
        UserModel newUser = userService.Save(userModel);

        Assert.assertNotNull(newUser.getId());
    }
}
