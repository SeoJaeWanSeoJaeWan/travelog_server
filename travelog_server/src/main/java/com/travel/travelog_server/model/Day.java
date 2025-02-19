package com.travel.travelog_server.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.travel.travelog_server.dto.Index;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
@Getter
@Setter
@Table(name="days")
public class Day implements Index {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer index;

    @ManyToOne
    @JoinColumn(name="logId")
    @JsonBackReference
    private Log log;

    @OneToMany(mappedBy="day",cascade=CascadeType.REMOVE,fetch=FetchType.LAZY)
    @JsonManagedReference
    private Set<Pin> pins;
}
