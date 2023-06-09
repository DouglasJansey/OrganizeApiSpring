package com.organize.myorganize.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@SuppressWarnings("ALL")
@Entity
@Table(name = "users")
@Data
public class UserModel implements Serializable {
    private static long serialVersionID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String email;
    private String password;
    private int phone;


}
