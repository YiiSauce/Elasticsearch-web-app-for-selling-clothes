package com.example.demo.controller;

import com.example.demo.document.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/kiki")
    public String saveStudent(@ModelAttribute("product") Product product) {
        service.save(product);
        return "redirect:/kiki ";
    }
    @GetMapping("/kiki/new")
    public String adding(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "add";
    }
    @GetMapping("/kiki/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", service.findById(id));
        return "modif";
    }
    @PostMapping("/kiki/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("product") Product product,
                                Model model) {

        // get student from database by id
        Product pro = service.findById(id);
        pro.setId(id);
        pro.setproductName(product.getproductName());
        pro.setLastName(product.getLastName());
        pro.setEmail(product.getEmail());

        // save updated student object
        service.save(pro);
        return "redirect:/students";
    }
}
