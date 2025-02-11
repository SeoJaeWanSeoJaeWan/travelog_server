package com.travel.travelog_server.controller.log.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateLogDto {
    @NotBlank
    private String title;
}
