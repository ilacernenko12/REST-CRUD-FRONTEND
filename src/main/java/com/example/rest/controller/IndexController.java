package com.example.rest.controller;

import com.example.rest.model.ClientModel;
import com.example.rest.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("index")
public class IndexController {
    @Autowired
    ClientService clientService;

    @PostMapping
    public RedirectView setData(@RequestParam String name,
                                @RequestParam String email,
                                @RequestParam String phone) {
        ClientModel clientModel = new ClientModel();
        clientModel.setName(name);
        clientModel.setEmail(email);
        clientModel.setPhone(phone);
        if (clientService.save(clientModel) != null) {
            return new RedirectView("/welcomepage");
        } else {
            return new RedirectView("/");
        }
    }

}
