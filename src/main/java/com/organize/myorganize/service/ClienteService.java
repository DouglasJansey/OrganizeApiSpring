package com.organize.myorganize.service;

import com.organize.myorganize.model.Cliente;
import com.organize.myorganize.model.Revendedor;
import com.organize.myorganize.model.UserModel;
import com.organize.myorganize.repository.ClienteRepository;
import com.organize.myorganize.repository.RevendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SuppressWarnings("ALL")
@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    private RevendedorRepository revendedorRepository;

    public Cliente save(Cliente cliente) {
      //  Optional<Revendedor> responseRevendedor = revendedorRepository.findByIdRevendedor(revendID);

        Cliente responseCliente = clienteRepository.save(cliente);

       // responseRevendedor.get().getClientes().add(responseCliente);
      // revendedorRepository.save(responseRevendedor.get());

       return cliente;
    }

    public List<Cliente> findAll() {
        List<Cliente> listClient = clienteRepository.findAll();
        return listClient;
    }

    public Cliente findByUserId(UserModel userCliente) {
        Cliente cliente = clienteRepository.findByUserIdCliente(userCliente);
        return cliente;
    }

}
