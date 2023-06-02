package com.organize.myorganize.service;

import com.organize.myorganize.dtos.ProductDtos;
import com.organize.myorganize.model.Cliente;
import com.organize.myorganize.model.Product;
import com.organize.myorganize.model.UserModel;
import com.organize.myorganize.repository.ClienteRepository;
import com.organize.myorganize.repository.ProductRepository;
import com.organize.myorganize.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@SuppressWarnings("ALL")
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    UserRepository userRepository;

    public Product save(ProductDtos produtoDtos){
        Product product = new Product();
        BeanUtils.copyProperties(produtoDtos, product);

        UserModel responseUser = userRepository.findByName(produtoDtos.getName());
        Cliente cliente = clienteRepository.findByUserIdCliente(responseUser);

        Product newProduct = productRepository.save(product);

        cliente.getProductList().add(newProduct);
        clienteRepository.save(cliente);

        return newProduct;
    }
}
