package com.example.demo.controller;

import com.example.demo.document.Product;
import com.example.demo.search.SearchRequestDTO;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService service;
    @Autowired
    public ProductController(ProductService service){
        this.service=service;
    }
//    @PostMapping("/createDocument")
//    public void save(@RequestBody Product p){
//        service.save(p);
//    }

    @GetMapping("{id}")
    public Product findById(@PathVariable Long id){
        return service.findById(id);
    }
//    @PostMapping
//    public ResponseEntity<Void> saveOne(@RequestBody Product p) {
//        service.save(p);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }

    @PostMapping("/search")
    public List<Product> search(@RequestBody final SearchRequestDTO dto) {
        return service.search(dto);
    }
}
