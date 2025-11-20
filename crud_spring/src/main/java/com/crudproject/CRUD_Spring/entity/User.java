package com.crudproject.CRUD_Spring.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;
}
