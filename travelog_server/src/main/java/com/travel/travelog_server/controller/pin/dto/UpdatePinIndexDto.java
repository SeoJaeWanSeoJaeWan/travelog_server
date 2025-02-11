package com.travel.travelog_server.controller.pin.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePinIndexDto {
    @NotBlank
    private Integer index;
}
