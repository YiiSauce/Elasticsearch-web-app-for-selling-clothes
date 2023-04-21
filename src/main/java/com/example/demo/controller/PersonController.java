package com.example.demo.controller;

import com.example.demo.document.Person;
import com.example.demo.service.PersonService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    private PersonService service;
    @Autowired
    public PersonController(PersonService service){
        this.service=service;
    }
    @PostMapping
    public void save(@RequestBody Person p){
        service.save(p);
    }
    @GetMapping("{id}")
    public Person findById(@PathVariable Long id){
        return service.findById(id);
    }

}
