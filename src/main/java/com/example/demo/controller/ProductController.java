package com.example.demo.controller;

import com.example.demo.document.Product;
import com.example.demo.search.SearchRequestDTO;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService service;
    @Autowired
    public ProductController(ProductService service){
        this.service=service;
    }
//    @PostMapping
//    public void save(@RequestBody Product p){
//        service.save(p);
//    }
//    @GetMapping("{id}")
//    public Product findById(@PathVariable Long id){
//        return service.findById(id);
//    }
    @PostMapping("/search")
    public List<Product> search(@RequestBody final SearchRequestDTO dto) {
        return service.search(dto);
    }
}
