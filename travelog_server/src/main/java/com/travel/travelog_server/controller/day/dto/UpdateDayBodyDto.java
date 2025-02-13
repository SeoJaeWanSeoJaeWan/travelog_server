package com.travel.travelog_server.controller.day.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDayBodyDto {
    @NotNull
    private Integer index;
}
