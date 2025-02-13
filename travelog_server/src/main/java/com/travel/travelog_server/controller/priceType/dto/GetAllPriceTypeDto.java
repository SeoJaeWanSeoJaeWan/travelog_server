package com.travel.travelog_server.controller.priceType.dto;

import com.travel.travelog_server.model.PriceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAllPriceTypeDto {
    private Long id;
    private String name;

    public GetAllPriceTypeDto(PriceType priceType) {
        this.id = priceType.getId();
        this.name = priceType.getName();
    }
}
