package com.travel.travelog_server.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="price_types")
@Getter
@Setter
@NoArgsConstructor
public class PriceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    public PriceType (String name) {
        this.name = name;
    }
}