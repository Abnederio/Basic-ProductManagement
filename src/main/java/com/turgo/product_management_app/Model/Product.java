package com.turgo.product_management_app.Model;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String type;
    private String place;
    private String warranty;
}
