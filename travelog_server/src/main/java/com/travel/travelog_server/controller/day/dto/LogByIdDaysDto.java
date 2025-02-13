package com.travel.travelog_server.controller.day.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.travel.travelog_server.controller.pin.dto.LogPinsDto;
import com.travel.travelog_server.model.Day;
import com.travel.travelog_server.model.DayPriceSummary;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class LogByIdDaysDto {
    private Long id;

    @JsonProperty("dayIndex")
    private Integer index;
    private Set<LogPinsDto> pins;
    private DayPriceSummary dayPriceSummary;

    public LogByIdDaysDto(Day day, DayPriceSummary dayPriceSummary) {
        this.id = day.getId();
        this.index = day.getIndex();
        this.pins = day.getPins().stream()
                .sorted((p1,p2) -> Integer.compare(p1.getIndex(), p2.getIndex()))
                .map(LogPinsDto::new)
                .collect(Collectors.toSet());

        this.dayPriceSummary = dayPriceSummary;
    }
}
