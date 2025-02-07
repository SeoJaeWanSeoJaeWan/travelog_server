package com.travel.travelog_server.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="pinUrls")
@Getter
@Setter
public class PinUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String url;

    @Column (nullable = false)
    private String title;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="pinId")
    private Pin pin;
}
