package com.example.demo.controller;

import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class UIContPro {
    @Autowired
    private ProductService service;
    @GetMapping("/kiki")
    public String viewHomePage(Model model) throws IOException {
        model.addAttribute("listt",service.getAll());
        return "tach";
    }
}
