package com.travel.travelog_server.controller.day.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateDayDto {
    private Integer index;
    private Long logId;
}
