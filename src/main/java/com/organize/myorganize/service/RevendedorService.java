package com.organize.myorganize.service;

import com.organize.myorganize.model.Revendedor;
import com.organize.myorganize.repository.RevendedorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@SuppressWarnings("ALL")
@Service
public class RevendedorService {
    @Autowired
    private RevendedorRepository revendedorRepository;
    public Revendedor save(Revendedor revendedor) {
       Revendedor newRevendedor =  revendedorRepository.save(revendedor);
        return newRevendedor;
    }

    public Optional<Revendedor> findByIdRevendedor(String codigo) {
        Optional<Revendedor> revendedora = revendedorRepository.findByIdRevendedor(codigo);
        return revendedora;
    }
}
