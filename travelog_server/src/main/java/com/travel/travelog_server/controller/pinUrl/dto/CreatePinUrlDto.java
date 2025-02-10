package com.travel.travelog_server.controller.pinUrl.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePinUrlDto {
    private String title;
    private String url;
    private Long pinId;
}
