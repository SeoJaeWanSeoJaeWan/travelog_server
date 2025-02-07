package com.travel.travelog_server.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.travel.travelog_server.controller.day.dto.LogDaysDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

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

    @JsonProperty("days")
    public List<LogDaysDto> getDaysAsDto() {
        return days.stream()
                .map(LogDaysDto::new)
                .collect(Collectors.toList());
    }
}

