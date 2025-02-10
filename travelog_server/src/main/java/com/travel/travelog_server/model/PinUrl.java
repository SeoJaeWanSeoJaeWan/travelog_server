package com.travel.travelog_server.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToOne
    @JoinColumn(name="pinId")
    @JsonBackReference
    private Pin pin;
}
