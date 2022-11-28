package com.example.rest.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client")
public class ClientModel {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String phone;
}
