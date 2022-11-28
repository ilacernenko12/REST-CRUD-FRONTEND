package com.example.rest.service;

import com.example.rest.model.ClientModel;
import com.example.rest.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void create(ClientModel clientModel) {
        clientRepository.save(clientModel);
    }

    public List<ClientModel> readAll() {
        return clientRepository.findAll();
    }

    public ClientModel read(long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public boolean update(ClientModel clientModel) {
        if (clientRepository.findById(clientModel.getId()).isPresent()) {
            clientRepository.save(clientModel);
            return true;
        }
        return false;
    }

    public boolean delete(long id) {
        return clientRepository.findById(id) != null;
    }

    public String getByNumber(String email) {
        ClientModel byEmail = clientRepository.findByEmail(email);
        return byEmail == null ? "" : byEmail.getPhone();
    }

    public ClientModel save(ClientModel clientModel) {
        ClientModel cm = null;
        try {
           cm = clientRepository.save(clientModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cm;
    }
}
