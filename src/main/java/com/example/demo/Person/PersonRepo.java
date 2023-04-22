package com.example.demo.Person;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface PersonRepo extends ElasticsearchRepository<Person,Long> {
    public Person findById(Long id);
    public void save(Person p);

    List<Person> findAll();
}
