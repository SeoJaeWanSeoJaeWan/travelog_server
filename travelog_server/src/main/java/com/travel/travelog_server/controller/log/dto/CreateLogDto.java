package com.travel.travelog_server.controller.log.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateLogDto {
    @NotNull(message="제목은 필수입니다.")
    private String title;
}
