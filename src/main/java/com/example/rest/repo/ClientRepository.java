package com.example.rest.repo;

import com.example.rest.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel,Long> {

    Optional<ClientModel> findById(Long id);
    ClientModel getById(Long id);


}