package com.example.demo.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.example.demo.document.Product;
import com.example.demo.helper.Indices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ElasticSearchQuery {
    @Autowired
    private ElasticsearchClient elasticsearchClient;
    public List<Product> searchAllDocuments() throws IOException {

        SearchRequest searchRequest =  SearchRequest.of(s -> s.index(Indices.PRODUCT_INDEX));
        SearchResponse searchResponse =  elasticsearchClient.search(searchRequest, Product.class);
        List<Hit> hits = searchResponse.hits().hits();
        List<Product> products = new ArrayList<>();
        for(Hit object : hits){

            System.out.print(((Product) object.source()));
            products.add((Product) object.source());

        }
        return products;
    }
}
