package com.organize.myorganize.dtos;

import lombok.Data;

@Data
public class UserDtos {
    private String name;
    private String email;
    private String password;
    private int phone;
    private Boolean isRevend;
    private String codRevend;
}
