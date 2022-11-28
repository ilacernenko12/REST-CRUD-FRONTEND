package com.example.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome_page")
public class WelcomePageController {
    @GetMapping
    public String getPage(){
        return "welcome_page";
    }
}
