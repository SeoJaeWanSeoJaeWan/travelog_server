package com.travel.travelog_server.controller.pin.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePinBodyDto {
    @NotNull
    private Double lat;

    @NotNull
    private Double lng;

    @NotNull
    private Long pinTypeId;

    @NotNull
    private Long dayId;

    @NotNull
    private Integer index;
}
