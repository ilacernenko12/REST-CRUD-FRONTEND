package com.example.rest.controller;

import com.example.rest.model.ClientModel;
import com.example.rest.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("welcomepage")
public class WelcomePageController {
    @Autowired
    ClientRepository clientRepository;
    @GetMapping
    public String getPage(Model model){
        model.addAttribute("client", clientRepository.findLastRegistered().orElse(null));
        return "/welcomepage";
    }
}
