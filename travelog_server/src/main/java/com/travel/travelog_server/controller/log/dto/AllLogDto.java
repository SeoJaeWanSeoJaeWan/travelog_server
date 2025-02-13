package com.travel.travelog_server.controller.log.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.travel.travelog_server.controller.day.dto.LogDaysDto;
import com.travel.travelog_server.model.Log;

import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class AllLogDto {
    private Long id;
    private String title;
    private String key;

    @JsonProperty("days")
    private List<LogDaysDto> days;

    public AllLogDto(Log log) {
        this.id = log.getId();
        this.title = log.getTitle();
        this.key = log.getKey();
        this.days = log.getDays().stream()
                .sorted((d1,d2) -> Integer.compare(d1.getIndex(), d2.getIndex()))
                .map(LogDaysDto::new)
                .collect(Collectors.toList());
    }
}