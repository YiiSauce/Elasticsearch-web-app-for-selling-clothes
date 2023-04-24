package com.example.demo.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class UICont {
    @Autowired
    private PersonService service;
    @GetMapping("/coco")
    public String viewHomePage(Model model) throws IOException {
        model.addAttribute("lista",service.getAll());
        return "modif";
    }
}
