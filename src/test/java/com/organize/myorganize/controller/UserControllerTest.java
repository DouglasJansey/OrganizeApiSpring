package com.organize.myorganize.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.organize.myorganize.dtos.UserDtos;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SuppressWarnings("ALL")
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void setup() throws Exception{
        UserDtos revendedora = new UserDtos();
        revendedora.setName("Douglas");
        revendedora.setPassword("1234");
        revendedora.setEmail("douglas.rodrigues@gmail.com");
        revendedora.setIsRevend(true);
        revendedora.setPhone(966609501);

        revendedora.setCodRevend("Rev_123");


        mockMvc.perform(post("/cadastrar")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(revendedora)))
                .andExpect(status().isCreated());

    }
    @Test
    public void shouldFindAnClienteByName() throws Exception{


        UserDtos cliente = new UserDtos();
        cliente.setName("Luana");
        cliente.setPassword("1234");
        cliente.setEmail("Luana.rodrigues@gmail.com");
        cliente.setIsRevend(false);
        cliente.setPhone(966609501);
        cliente.setCodRevend("Rev_123");


        mockMvc.perform(post("/cadastrar")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(cliente)))
                .andReturn();

        mockMvc.perform(get("/cliente?name=Luana"))
                .andExpect(status().is2xxSuccessful());


    }

    @Test
    public void shouldSaveClienteInRevender() throws Exception {
        UserDtos revendedora = new UserDtos();
        revendedora.setName("Luana");
        revendedora.setPassword("1234");
        revendedora.setEmail("Luana.rodrigues@gmail.com");
        revendedora.setIsRevend(true);
        revendedora.setPhone(966609501);


         mockMvc.perform(post("/cadastrar")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(revendedora)))
                        .andExpect(status().isCreated());


    }

}