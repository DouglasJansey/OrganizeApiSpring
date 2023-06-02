package com.organize.myorganize.controller;

import com.organize.myorganize.dtos.ProductDtos;
import com.organize.myorganize.model.Product;
import com.organize.myorganize.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/produtos")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping
    public ResponseEntity saveProdcut(@RequestBody ProductDtos productDtos){
      Product product = productService.save(productDtos);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(product);
    }
}
