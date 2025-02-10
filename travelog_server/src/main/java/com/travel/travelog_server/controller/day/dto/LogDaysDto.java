package com.travel.travelog_server.controller.day.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.travel.travelog_server.controller.pin.dto.LogPinsDto;
import com.travel.travelog_server.model.Day;

import java.util.Set;
import java.util.stream.Collectors;

public class LogDaysDto {
    @JsonProperty("dayIndex")
    private Integer index;

    @JsonProperty("pins")
    private Set<LogPinsDto> pins;

    public LogDaysDto(Day day) {
        this.index = day.getIndex();
        this.pins = day.getPins().stream()
                .sorted((p1,p2) -> Integer.compare(p1.getIndex(), p2.getIndex()))
                .map(LogPinsDto::new)
                .collect(Collectors.toSet());
    }
}
