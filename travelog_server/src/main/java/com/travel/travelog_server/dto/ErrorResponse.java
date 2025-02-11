package com.travel.travelog_server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class ErrorResponse {
    private String code;
    private String message;
    private Map<String, String> errors;
}
