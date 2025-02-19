package com.travel.travelog_server.controller.log.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CheckKeyBodyDto {
    @NotBlank
    private String key;
}
