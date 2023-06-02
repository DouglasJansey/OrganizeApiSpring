package com.organize.myorganize.dtos;

import lombok.Data;

@Data
public class ProductDtos {

    private String codProduct;
    private String name;
    private String description;
    private int quantity;
    private Double price;
    private String nameCliente;
}
