package com.organize.myorganize.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@SuppressWarnings("ALL")
@Entity
@Data
public class Product implements Serializable {
    private static long serialVersionID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String codProduct;
    private String name;
    private String description;
    private String quantity;
    private Double price;
}
