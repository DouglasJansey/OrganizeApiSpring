package com.organize.myorganize.model;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@SuppressWarnings("ALL")
@Entity
@Data
public class Cliente implements Serializable {
    private static long serialVersionID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @OneToOne
    @JoinColumn(name = "userId")
    private UserModel userIdCliente;

    @OneToMany
    private List<Product> productList;


}
