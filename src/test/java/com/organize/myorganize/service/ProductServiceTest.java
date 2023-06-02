package com.organize.myorganize.service;

import com.organize.myorganize.dtos.ProductDtos;
import com.organize.myorganize.model.Cliente;
import com.organize.myorganize.model.Product;
import com.organize.myorganize.model.UserModel;
import com.organize.myorganize.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
@SuppressWarnings("ALL")
@RunWith(SpringRunner.class)
public class ProductServiceTest {
        @TestConfiguration
        static class ProductServiceConfigurationTest {
                @Bean
                public ProductService revendedorService(){
                        return new ProductService();
                }
        }
        @Autowired
        ProductService productService;
        @MockBean
        private ProductRepository productRepository;


        @Test
        public void shouldReturnAnClienteAndAProduct(){
                UserModel usermodel = new UserModel();
                usermodel.setId(UUID.randomUUID());
                usermodel.setName("Douglas");
                usermodel.setEmail("douglas.jansey@gmail.com");
                usermodel.setPhone(980846797);
                usermodel.setPassword("1234567");

                Cliente cliente = new Cliente();
                List<Product> listProduct = new ArrayList<>();

                cliente.setUserIdCliente(usermodel);
                cliente.setId(UUID.randomUUID());
                cliente.setProductList(listProduct);


                ProductDtos produto = new ProductDtos();
                produto.setCodProduct("05745d");
                produto.setName("Perfume");
                produto.setDescription("perfume avon");
                produto.setQuantity(5);
                produto.setPrice(59.99);

               Product newProduct = productService.save(produto);

               cliente.getProductList().add(newProduct);

                Mockito.when(productRepository.save(Mockito.any()))
                        .thenReturn(produto);

                Assert.assertNotNull(cliente.getProductList());
        }


}