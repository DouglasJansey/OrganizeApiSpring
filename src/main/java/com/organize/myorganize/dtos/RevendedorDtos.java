package com.organize.myorganize.dtos;

import com.organize.myorganize.model.Cliente;
import com.organize.myorganize.model.UserModel;
import lombok.Data;

import java.util.List;
@Data
public class RevendedorDtos {

    private String idRevendedor;
    private UserModel userid;
    private List<Cliente> clientes;
}
