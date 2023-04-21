package com.example.demo.service;

import com.example.demo.document.Person;
import com.example.demo.document.Product;
import com.example.demo.helper.Indices;
import com.example.demo.repository.PersonRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PersonService {

    private PersonRepo repo;
    @Autowired
    public PersonService(PersonRepo repo){
        this.repo=repo;
    }
    public void save(Person p){
        repo.save(p);
    }
    public Person findById(Long id){
        return repo.findById(id);
    }
}
//    private final RestHighLevelClient client;
//    private static final ObjectMapper MAPPER = new ObjectMapper();
//    private static final Logger LOG = LoggerFactory.getLogger(ProductService.class);
//
//    @Autowired
//    public PersonService(RestHighLevelClient clt) {
//        this.client = clt;
//    }
//
//    public List<Product> search(final SearchRequestDTO dto) {
//        final SearchRequest request = SearchUtil.buildSearchRequest(
//                Indices.PRODUCT_INDEX,
//                dto
//        );
//        if (request == null) {
//            LOG.error("Failed to build search request");
//            return Collections.emptyList();
//        }
//        try {
//            final SearchResponse response = client.search(request, RequestOptions.DEFAULT);
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
//        } catch (
//                Exception e) {
//            LOG.error(e.getMessage(), e);
//            return Collections.emptyList();
//        }
//
//    }
