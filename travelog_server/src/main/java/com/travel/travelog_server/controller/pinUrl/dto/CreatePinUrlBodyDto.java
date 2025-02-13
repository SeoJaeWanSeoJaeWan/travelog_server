package com.travel.travelog_server.controller.pinUrl.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePinUrlBodyDto {
    @NotBlank
    private String title;

    @NotBlank
    private String url;

    @NotNull
    private Long pinId;
}
