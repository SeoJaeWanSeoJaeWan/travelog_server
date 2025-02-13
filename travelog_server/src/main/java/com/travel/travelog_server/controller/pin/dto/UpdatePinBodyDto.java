package com.travel.travelog_server.controller.pin.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
public class UpdatePinBodyDto {
    @NotNull
    private Double lat;

    @NotNull
    private Double lng;

    private String title;

    private String description;

    private String picture;

    @NotNull
    private Integer price;

    @NotNull
    private Long pinTypeId;

    @NotNull
    private Long priceTypeId;
}
