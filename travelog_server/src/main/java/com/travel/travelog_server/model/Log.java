package com.travel.travelog_server.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@Table(name="logs")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String key;

    @Column(nullable = false)
    private String title;

    @OneToMany(mappedBy="log", cascade=CascadeType.REMOVE, fetch=FetchType.LAZY)
    @JsonManagedReference
    private List<Day> days;
}

