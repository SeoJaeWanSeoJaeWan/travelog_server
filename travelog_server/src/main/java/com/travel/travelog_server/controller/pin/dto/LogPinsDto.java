package com.travel.travelog_server.controller.pin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.travel.travelog_server.model.Pin;

import lombok.*;

@Getter
@Setter
public class LogPinsDto {
    @JsonProperty("pinIndex")
    private Integer index;

    private Double lat;
    private Double lng;

    public LogPinsDto(Pin pin) {
        this.index = pin.getIndex();
        this.lat = pin.getLat();
        this.lng = pin.getLng();
    }
}
