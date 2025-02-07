package com.travel.travelog_server.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="priceTypes")
@Getter
@Setter
public class PriceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}