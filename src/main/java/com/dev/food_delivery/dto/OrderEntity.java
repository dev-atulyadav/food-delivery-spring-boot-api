package com.dev.food_delivery.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class OrderEntity {
    @Id
    private Long id;
    private String product;
    private Integer quantity;
    private Double price;

    @ManyToOne
    @JsonBackReference
    private UserEntity user;
}
