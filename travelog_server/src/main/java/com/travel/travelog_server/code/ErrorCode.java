package com.travel.travelog_server.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // Body
    VALIDATION_ERROR("V001", "요청값이 올바르지 않습니다."),

    // DB
    ENTITY_NOT_FOUND_ERROR("E001", "해당 엔티티를 찾을 수 없습니다."),

    // File
    FILE_EXTENSION_ERROR("F001", "지원하지 않는 파일 확장자입니다."),
    FILE_SAVE_ERROR("F002", "파일 저장에 실패했습니다."),
    MAX_FILE_SIZE_ERROR("F003", "파일 크기가 너무 큽니다.");

    private String code;
    private String message;
}
