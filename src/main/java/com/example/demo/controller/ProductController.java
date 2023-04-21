package com.example.demo.controller;

import com.example.demo.document.Product;
import com.example.demo.service.ElasticSearchQuery;
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
    @PostMapping
    public void save(@RequestBody Product p){
        service.save(p);
    }
    @GetMapping("{id}")
    public Product findById(@PathVariable Long id){
        return service.findById(id);
    }
//    @PostMapping("/search")
//    public List<Product> search(@RequestBody final SearchRequestDTO dto) {
//        return service.search(dto);
//    }

    @Autowired
    private ElasticSearchQuery elasticSearchQuery;
    @GetMapping("/searchDocument")
    public List<Product> searchAllDocument() throws IOException {
        List<Product> products = elasticSearchQuery.searchAllDocuments();
        return (List<Product>) new ResponseEntity<>(products, HttpStatus.OK);
    }
}
