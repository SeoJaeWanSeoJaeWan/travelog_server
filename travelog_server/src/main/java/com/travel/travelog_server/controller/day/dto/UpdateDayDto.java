package com.travel.travelog_server.controller.day.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDayDto {
    @NotBlank
    private Integer index;
}
