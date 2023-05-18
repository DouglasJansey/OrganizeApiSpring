package com.organize.myorganize.ControllerTest;

import com.organize.myorganize.MyorganizeApplication;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
public class ControllerUserTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void ControllerTestGetAll() throws Exception{
      mockMvc.perform(MockMvcRequestBuilders.get("/usuarios"))
              .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
