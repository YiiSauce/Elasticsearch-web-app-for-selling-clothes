package com.example.demo.repository;


import com.example.demo.document.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends ElasticsearchRepository<Product, Long> {

    void save(Product p);

    Product findById(Long id);

    List<Product> findAll();

    void deleteById(Long id);
}