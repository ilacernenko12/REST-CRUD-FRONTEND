package com.example.rest.controller;

import com.example.rest.model.ClientModel;
import com.example.rest.repo.ClientRepository;
import com.example.rest.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping (value =  "/clients") // обрабатывает POST запросы на адрес /clients
    public RedirectView create (@RequestBody ClientModel clientModel) {
        clientService.create(clientModel);
        return new RedirectView("/"); // класс для возврата ответов
    }

    @GetMapping (value = "/clients")
    public ResponseEntity<List<ClientModel>> read() {
        final List<ClientModel> clientModels = clientService.readAll();

        return clientModels != null && !clientModels.isEmpty()
                ? new ResponseEntity<>(clientModels, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping (value = "/clients{id}")
    public ResponseEntity<ClientModel> readById (@PathVariable(name = "id") long id) {
        ClientModel clientModel = clientService.read(id);
        return clientModel != null
                ? new ResponseEntity<>(clientModel, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping (value = "/clients{id}")
    public ResponseEntity<?> update (@PathVariable(name = "id") long id, @RequestBody ClientModel clientModel) {
        final boolean updated = clientService.update(clientModel);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/clients{id}")
    public ResponseEntity<?> delete (@PathVariable (name = "id") long id) {
        final boolean deleted = clientService.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping (value = "/get_number")
    public String getNumber (@RequestParam (name = "email") String email) {
        return clientService.getNumberByEmail(email);
    }

    @GetMapping (value = "/get_email")
    public String getEmail (@RequestParam (name = "number") String number) {
        return clientService.getEmailByNumber(number);
    }

    @PostMapping("/set_android_data")
    public ClientModel setAndroidData (@RequestBody ClientModel model) {
        return clientService.save(model);
    }
}
