package com.travel.travelog_server.controller.pin.dto;

import lombok.*;

@Setter
@Getter
public class UpdatePinDto {
    private Double lat;
    private Double lng;
    private String title;
    private String description;
    private String picture;
    private Integer price;
    private Long pinTypeId;
    private Long priceTypeId;
}
