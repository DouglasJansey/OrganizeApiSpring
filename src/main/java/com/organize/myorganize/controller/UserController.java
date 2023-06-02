package com.organize.myorganize.controller;

import com.organize.myorganize.dtos.UserDtos;
import com.organize.myorganize.model.Cliente;
import com.organize.myorganize.model.Product;
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
@RequestMapping
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RevendedorService revendedorService;
    @Autowired
    ClienteService clienteService;

    @GetMapping("/clientes")
    public ResponseEntity<Object> getAll(){
        List<Cliente> clienteslist = clienteService.findAll();
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(clienteslist);
    }
    @GetMapping("/cliente")
    public ResponseEntity<Object> getUser(@RequestParam String name){
        UserModel user = userService.findByName(name);
        Cliente newCliente = clienteService.findByUserId(user);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(newCliente);
    }
    @GetMapping("/usuario")
    public ResponseEntity<Object> getAll(@RequestParam String codigo){
        Optional<Revendedor> revendedora = revendedorService.findByIdRevendedor(codigo);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(revendedora);
    }
    @PostMapping("/revendedor")
    public ResponseEntity<Object> createRevendedora(@RequestBody Revendedor revendedor) {

      Revendedor newRevendedor =  revendedorService.save(revendedor);

        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(newRevendedor);

    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> createUser(@RequestBody UserDtos userDtos) {
        UserModel userResponse = userService.Save(userDtos);
        Revendedor newRevendedor = new Revendedor();
        Cliente cliente = new Cliente();
        Boolean isRevend = userDtos.getIsRevend();

        if (isRevend == true) {
            List<Cliente> listClient = new ArrayList<>();

            String userID = userResponse.getId().toString();
            String revendID = "REV" + userID.substring(0, 5);

            newRevendedor.setIdRevendedor(revendID);
            newRevendedor.setUserid(userResponse);
            newRevendedor.setClientes(listClient);
            revendedorService.save(newRevendedor);
            return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(newRevendedor);

        }else{
            if(userDtos.getCodRevend() != null){
                List<Product> productList = new ArrayList<>();
              cliente.setUserIdCliente(userResponse);
              cliente.setProductList(productList);
              Cliente responseCliente = clienteService.save(cliente);
               return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(responseCliente);
            }

        }





        return ResponseEntity.status(HttpStatusCode.valueOf(401)).body("Não foi possível salvar");
    }

}
