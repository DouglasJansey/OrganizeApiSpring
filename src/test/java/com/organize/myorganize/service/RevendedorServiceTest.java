package com.organize.myorganize.service;

import com.organize.myorganize.model.Cliente;
import com.organize.myorganize.model.Revendedor;
import com.organize.myorganize.model.UserModel;
import com.organize.myorganize.repository.RevendedorRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import static org.junit.Assert.assertNotNull;

@SuppressWarnings("ALL")
@RunWith(SpringRunner.class)
public class RevendedorServiceTest {
   @TestConfiguration
    static class revendedorConfigurationTest {
        @Bean
        public RevendedorService revendedorService(){
            return new RevendedorService();
        }
    }
    @Autowired
    RevendedorService revendedorService;
    @MockBean
    RevendedorRepository revendedorRepository;

   @Before
   public void setup(){

   }

    @Test
    public void shouldCreateNewRevenderAndReturnStatusCode201(){
        UserModel user = new UserModel();
        user.setId(UUID.randomUUID());
        user.setName("Douglas");
        user.setPassword("1234");
        user.setEmail("douglas.jansey@gmail.com");

        Cliente cliente = new Cliente();
        cliente.setUserIdCliente(user);
        cliente.setId(user.getId());

        List<Cliente> listClient = new ArrayList<>();
        listClient.add(cliente);

        Revendedor revenderDtos = new Revendedor();
        String userID = user.getId().toString();
        String revendID = "REV_" + userID.substring(0,5);
        revenderDtos.setIdRevendedor(revendID);
        revenderDtos.setUserid(user);
        revenderDtos.setClientes(listClient);


        Revendedor newRevender = new Revendedor();

        newRevender.setId(UUID.randomUUID());
        newRevender.setIdRevendedor(revenderDtos.getIdRevendedor());
        newRevender.setUserid(revenderDtos.getUserid());
        newRevender.setClientes(revenderDtos.getClientes());



        Mockito.when(revendedorRepository.save(Mockito.any()))
                .thenReturn(newRevender);

        revendedorService.save(revenderDtos);




        assertNotNull(newRevender.getId());


    }

}