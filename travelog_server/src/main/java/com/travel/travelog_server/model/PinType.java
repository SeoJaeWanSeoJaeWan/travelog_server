package com.travel.travelog_server.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="pin_types")
@Getter
@Setter
@NoArgsConstructor
public class PinType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String icon;

    public PinType (String name, String url) {
        this.name = name;
        this.icon = url;
    }
}