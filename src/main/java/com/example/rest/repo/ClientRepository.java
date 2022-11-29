package com.example.rest.repo;

import com.example.rest.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel,Long> {

    Optional<ClientModel> findById(Long id);
    ClientModel getById(Long id);
    List<ClientModel> findNameById(long id);
    @Query("select c from ClientModel c order by c.id desc limit 1")
    Optional<ClientModel> findLastRegistered();

    ClientModel findByEmail(String email);
    ClientModel findByPhone(String phone);
}