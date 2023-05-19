package com.organize.myorganize.repository;

import com.organize.myorganize.model.Revendedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RevendedorRepository extends JpaRepository<Revendedor, UUID> {
}
