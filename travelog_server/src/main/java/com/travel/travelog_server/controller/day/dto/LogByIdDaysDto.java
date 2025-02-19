package com.travel.travelog_server.controller.day.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.travel.travelog_server.model.Day;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogByIdDaysDto {
    private Long id;

    @JsonProperty("index")
    private Integer index;

    public LogByIdDaysDto(Day day) {
        this.id = day.getId();
        this.index = day.getIndex();
    }
}
