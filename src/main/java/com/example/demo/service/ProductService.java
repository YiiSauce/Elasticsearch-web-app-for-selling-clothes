package com.example.demo.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.example.demo.document.Product;
import com.example.demo.repository.ProductRepo;
import com.example.demo.search.SearchRequestDTO;
import com.example.demo.search.util.SearchUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductService {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final Logger LOG = LoggerFactory.getLogger(ProductService.class);


//    private RestClient elasticsearchClient;
    private final RestHighLevelClient elasticsearchClient;
    @Autowired
    public ProductService(RestHighLevelClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }

    public List<Product> search(final SearchRequestDTO dto) {
         final SearchRequest searchRequest = SearchUtil.buildSearchRequest("product", dto);
         if(searchRequest==null){
             LOG.error("failed to build");
             return Collections.emptyList();
         }

        try {

             SearchResponse response = elasticsearchClient.search(searchRequest, RequestOptions.DEFAULT);

            final SearchHit[] searchHits = response.getHits().getHits();
            final List<Product> pros = new ArrayList<>(searchHits.length);
            for (SearchHit hit : searchHits) {
                pros.add(
                        MAPPER.readValue(hit.getSourceAsString(), Product.class)
                );
            }

            return pros;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Autowired
    private ProductRepo repo;
    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    public void save(Product p){
//        IndexQuery indexQuery = new IndexQueryBuilder()
//                .withObject(p)
//                .withIndex("product")
//                .build();
//        elasticsearchOperations.index(indexQuery, IndexCoordinates.of("product"));
      repo.save(p);
    }
    public Product findById(Long id){
        return repo.findById(id);
    }
    public List<Product> getAll(){
        return repo.findAll();
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

}