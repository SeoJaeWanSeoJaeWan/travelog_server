package com.travel.travelog_server.controller.pin.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePinDto {
    private Double lat;
    private Double lng;
    private Long pinTypeId;
    private Long dayId;
    private Integer index;
}
