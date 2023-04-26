package com.example.demo.repository;

import com.example.demo.Person.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepo extends ElasticsearchRepository<Person,Long> {
    public Person findById(Long id);
    public void save(Person p);

    List<Person> findAll();
}
