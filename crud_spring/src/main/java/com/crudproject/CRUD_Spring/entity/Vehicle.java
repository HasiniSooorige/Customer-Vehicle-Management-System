package com.crudproject.CRUD_Spring.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name ="vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String color;
    private String type;
    private String mileage;
    private String customerId;

}
