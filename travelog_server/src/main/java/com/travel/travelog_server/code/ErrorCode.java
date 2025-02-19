package com.travel.travelog_server.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // Body
    VALIDATION_ERROR("V001", "요청값이 올바르지 않습니다."),
    VALIDATION_MULTIPART_ERROR("V002", "파일이 필요합니다."),

    // DB
    ENTITY_NOT_FOUND_ERROR("E001", "해당 정보를 찾을 수 없습니다."),
    ENTITY_NOT_FOUND_KEY_ERROR("E002", "해당 코드를 가진 여행 일정을 찾을 수 없습니다."),

    // File
    FILE_EXTENSION_ERROR("F001", "지원하지 않는 파일 확장자입니다."),
    FILE_SAVE_ERROR("F002", "파일 저장에 실패했습니다."),
    MAX_FILE_SIZE_ERROR("F003", "파일 크기가 너무 큽니다."),
    FILE_NOT_FOUND_ERROR("F004", "파일을 찾을 수 없습니다."),
    FILE_PATH_ERROR("F005", "파일 경로가 올바르지 않습니다."),
    FILE_NAME_ERROR("F006", "파일 이름이 올바르지 않습니다.");


    private String code;
    private String message;
}
