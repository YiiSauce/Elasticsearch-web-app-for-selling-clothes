package com.example.demo.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.example.demo.document.Product;
import com.example.demo.repository.ProductRepo;
import com.example.demo.search.SearchRequestDTO;
import com.example.demo.search.util.SearchUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductService {
//    private static final ObjectMapper MAPPER = new ObjectMapper();
//    private static final Logger LOG = LoggerFactory.getLogger(ProductService.class);
//
//
//    private ElasticsearchClient elasticsearchClient;
//    public ProductService(ElasticsearchClient elasticsearchClient) {
//        this.elasticsearchClient = elasticsearchClient;
//    }

//    public List<Product> search( SearchRequestDTO dto) {
//         SearchRequest searchRequest = SearchUtil.buildSearchRequest("product", dto);
//
//
//        try {
//
//             SearchResponse response = elasticsearchClient.search(searchRequest,Product.class);
//
//            final SearchHit[] searchHits = response.getHits().getHits();
//            final List<Product> vehicles = new ArrayList<>(searchHits.length);
//            for (SearchHit hit : searchHits) {
//                vehicles.add(
//                        MAPPER.readValue(hit.getSourceAsString(), Product.class)
//                );
//            }
//
//            return vehicles;
//        } catch (Exception e) {
//            LOG.error(e.getMessage(), e);
//            return Collections.emptyList();
//        }
//    }

    @Autowired
    private ProductRepo repo;

    public ProductService(ProductRepo repo){
        this.repo=repo;
    }
    public void save(Product p){
        repo.save(p);
    }
    public Product findById(Long id){
        return repo.findById(id);
    }
    public List<Product> getAll(){
        return repo.findAll();
    }

}