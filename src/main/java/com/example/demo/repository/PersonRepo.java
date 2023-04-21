package com.example.demo.repository;

import com.example.demo.document.Person;
import com.example.demo.document.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.support.ElasticsearchEntityInformation;

import java.util.List;

public interface PersonRepo extends ElasticsearchRepository<Person,Long> {
    public Person findById(Long id);
    public void save(Person p);

}
