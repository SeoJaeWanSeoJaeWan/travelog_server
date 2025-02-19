package com.travel.travelog_server.controller.pin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.travel.travelog_server.model.Pin;

import lombok.*;

@Getter
@Setter
public class DayPinsDto {
    private Long id;

    @JsonProperty("index")
    private Integer index;

    private Double lat;
    private Double lng;

    private String pinType;

    public DayPinsDto(Pin pin) {
        this.id = pin.getId();
        this.index = pin.getIndex();
        this.lat = pin.getLat();
        this.lng = pin.getLng();
        this.pinType = pin.getPinType().getName();
    }
}
