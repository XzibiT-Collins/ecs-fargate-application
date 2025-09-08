package com.example.ecsapplication.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/")
public class HelloController {

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "ECS Application");
        return "index";
    }
}
