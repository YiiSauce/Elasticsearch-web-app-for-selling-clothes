package com.example.demo.repository;

import com.example.demo.document.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends ElasticsearchRepository<Product,Long>{
}
