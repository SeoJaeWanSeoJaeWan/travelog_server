package com.travel.travelog_server.controller.log.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckKeyDto {
    @NotBlank
    private String key;
}
