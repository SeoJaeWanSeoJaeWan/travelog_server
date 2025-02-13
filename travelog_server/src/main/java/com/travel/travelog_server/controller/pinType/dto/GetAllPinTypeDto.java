package com.travel.travelog_server.controller.pinType.dto;

import com.travel.travelog_server.model.PinType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAllPinTypeDto {
    private Long id;
    private String name;
    private String icon;

    public GetAllPinTypeDto(PinType pinType) {
        this.id = pinType.getId();
        this.name = pinType.getName();
        this.icon = pinType.getIcon();
    }
}
