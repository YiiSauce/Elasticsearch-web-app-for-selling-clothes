package com.example.demo.controller;

import com.example.demo.document.Product;
import com.example.demo.search.ElasticSearchQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class ProductClientController {
//    private ProductService service;
//    @Autowired
//    public ProductController(ProductService service){
//        this.service=service;
//    }
//    @PostMapping
//    public void save(@RequestBody Product p){
//        service.save(p);
//    }
//    @GetMapping("{id}")
//    public Product findById(@PathVariable Long id){
//        return service.findById(id);
//    }

    @Autowired
    private ElasticSearchQuery elasticSearchQuery;

    @PostMapping("/createOrUpdateDocument")
    public ResponseEntity<Object> createOrUpdateDocument(@RequestBody Product product) throws IOException {
        String response = elasticSearchQuery.createOrUpdateDocument(product);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getDocument")
    public ResponseEntity<Object> getDocumentById(@RequestParam String productId) throws IOException {
        Product product =  elasticSearchQuery.getDocumentById(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/deleteDocument")
    public ResponseEntity<Object> deleteDocumentById(@RequestParam String productId) throws IOException {
        String response =  elasticSearchQuery.deleteDocumentById(productId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/searchDocument")
    public ResponseEntity<Object> searchAllDocument() throws IOException {
        List<Product> products = elasticSearchQuery.searchAllDocuments();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
