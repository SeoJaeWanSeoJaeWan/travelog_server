package com.travel.travelog_server.controller.pin.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePinIndexBodyDto {
    @NotNull
    private Integer index;
}
