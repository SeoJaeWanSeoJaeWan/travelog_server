package com.travel.travelog_server.controller.log.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateLogBodyDto {
    @NotBlank
    private String title;
}
