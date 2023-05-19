package com.organize.myorganize.service;

import com.organize.myorganize.dtos.RevendedorDtos;
import com.organize.myorganize.model.Revendedor;
import com.organize.myorganize.repository.RevendedorRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RevendedorService {
    @Autowired
    private RevendedorRepository revendedorRepository;
    public Revendedor save(RevendedorDtos revenderDtos) {
        Revendedor revendedor = new Revendedor();
        BeanUtils.copyProperties(revenderDtos, revendedor);
        revendedorRepository.save(revendedor);
        return revendedor;
    }
}
