package com.organize.myorganize.controller;

import com.organize.myorganize.dtos.RevendedorDtos;
import com.organize.myorganize.dtos.UserDtos;
import com.organize.myorganize.model.Cliente;
import com.organize.myorganize.model.Revendedor;
import com.organize.myorganize.model.UserModel;
import com.organize.myorganize.service.ClienteService;
import com.organize.myorganize.service.RevendedorService;
import com.organize.myorganize.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/cadastrar")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RevendedorService revendedorService;
    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<Cliente> clienteslist = clienteService.findAll();
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(clienteslist);
    }
    @GetMapping("/{phone}")
    public ResponseEntity<Object> getAll(@RequestParam(value = "tphone") int phone){
        Optional<UserModel> userModel = userService.findOne(phone);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(userModel);
    }
    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody UserDtos userDtos) {
        UserModel userResponse = userService.Save(userDtos);
        Revendedor newRevendedor = new Revendedor();
        Cliente cliente = new Cliente();

        if (userDtos.getIsRevend() == true) {
            List<Cliente> listClient = new ArrayList<>();

            RevendedorDtos revenderDtos = new RevendedorDtos();
            String userID = userResponse.getId().toString();
            String revendID = "REV" + userID.substring(0, 5);
            revenderDtos.setIdRevendedor(revendID);
            revenderDtos.setUserid(userResponse);
            revenderDtos.setClientes(listClient);
            newRevendedor = revendedorService.save(revenderDtos);

        }
        cliente.setUserIdCliente(userResponse);

        Cliente responseCliente = clienteService.save(cliente);
        Boolean isRevend = userDtos.getIsRevend();
        ResponseEntity<Object> response = isRevend == false
        ? ResponseEntity.status(HttpStatusCode.valueOf(201)).body(userResponse)
        : ResponseEntity.status(HttpStatusCode.valueOf(201)).body(newRevendedor);

        return response;
    }

}
