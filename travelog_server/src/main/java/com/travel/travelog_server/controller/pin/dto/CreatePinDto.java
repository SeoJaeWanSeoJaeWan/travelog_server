package com.travel.travelog_server.controller.pin.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePinDto {
    @NotBlank
    private Double lat;

    @NotBlank
    private Double lng;

    @NotBlank
    private Long pinTypeId;

    @NotBlank
    private Long dayId;

    @NotBlank
    private Integer index;
}
