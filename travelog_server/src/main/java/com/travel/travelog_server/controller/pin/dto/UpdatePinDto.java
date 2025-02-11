package com.travel.travelog_server.controller.pin.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
public class UpdatePinDto {
    @NotBlank
    private Double lat;

    @NotBlank
    private Double lng;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private String picture;

    @NotBlank
    private Integer price;

    @NotBlank
    private Long pinTypeId;

    @NotBlank
    private Long priceTypeId;
}
