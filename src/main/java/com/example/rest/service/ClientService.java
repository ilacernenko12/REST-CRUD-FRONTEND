package com.example.rest.service;

import com.example.rest.model.ClientModel;
import com.example.rest.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ClientService {

    /*private static final Map<Long, Client> CLIENT_REPOSITORY_MAP = new HashMap<>();*/
    private static final AtomicLong CLIENT_ID_HOLDER = new AtomicLong();
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
}
