package com.example.demo.repository;


import com.example.demo.document.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends ElasticsearchRepository<Product, Long> {

    void save(Product p);

    Product findById(Long id);
}