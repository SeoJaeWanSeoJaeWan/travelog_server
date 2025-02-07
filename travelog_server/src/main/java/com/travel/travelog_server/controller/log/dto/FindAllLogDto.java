package com.travel.travelog_server.controller.log.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.travel.travelog_server.controller.day.dto.LogDaysDto;
import com.travel.travelog_server.model.Log;

import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class FindAllLogDto {
    private Long id;
    private String title;

    @JsonProperty("days")
    private List<LogDaysDto> days;

    public FindAllLogDto(Log log) {
        this.id = log.getId();
        this.title = log.getTitle();
        this.days = log.getDays().stream()
                .map(LogDaysDto::new)
                .collect(Collectors.toList());
    }
}