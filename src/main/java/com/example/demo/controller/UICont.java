package com.example.demo.controller;

import com.example.demo.service.ElasticSearchQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class UICont {
    @Autowired
    private ElasticSearchQuery elasticSearchQuery;
    @GetMapping("/")
    public String viewHomePage(Model model) throws IOException {
        model.addAttribute("listProductDocuments",elasticSearchQuery.searchAllDocuments());
        return "test";
    }
}
