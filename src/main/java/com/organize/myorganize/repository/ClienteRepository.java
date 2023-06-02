package com.organize.myorganize.repository;

import com.organize.myorganize.model.Cliente;
import com.organize.myorganize.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
    Cliente findByUserIdCliente(UserModel userCliente);
}
