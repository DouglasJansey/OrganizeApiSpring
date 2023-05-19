package com.organize.myorganize.service;

import com.organize.myorganize.model.Cliente;
import com.organize.myorganize.model.UserModel;
import com.organize.myorganize.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Cliente save(Cliente cliente) {
       return clienteRepository.save(cliente);
    }

    public List<Cliente> findAll() {
        List<Cliente> listClient = clienteRepository.findAll();
        return listClient;
    }

}
