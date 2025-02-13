package com.travel.travelog_server.controller.priceType.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePriceTypeBodyDto {
    @NotBlank
    private String name;
}
