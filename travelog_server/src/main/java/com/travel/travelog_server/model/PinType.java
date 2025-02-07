package com.travel.travelog_server.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="pinTypes")
@Getter
@Setter
public class PinType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String icon;
}