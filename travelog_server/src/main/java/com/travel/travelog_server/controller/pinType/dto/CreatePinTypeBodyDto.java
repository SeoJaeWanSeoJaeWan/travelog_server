package com.travel.travelog_server.controller.pinType.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePinTypeBodyDto {
    @NotBlank
    private String name;

    @NotBlank
    private String icon;
}
