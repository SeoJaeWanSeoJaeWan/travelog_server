package com.travel.travelog_server.controller.pinUrl.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePinUrlDto {
    @NotBlank
    private String title;

    @NotBlank
    private String url;

    @NotBlank
    private Long pinId;
}
