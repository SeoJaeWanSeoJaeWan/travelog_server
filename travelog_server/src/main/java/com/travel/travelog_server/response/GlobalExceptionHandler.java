package com.travel.travelog_server.response;

import com.travel.travelog_server.code.ErrorCode;
import com.travel.travelog_server.dto.ErrorResponse;
import com.travel.travelog_server.exception.FileSaveException;
import jakarta.persistence.EntityNotFoundException;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    // Body @Valid 예외 처리
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        for(FieldError error : ex.getBindingResult().getFieldErrors()) {
            String field = error.getField();
            String message = error.getDefaultMessage();

            errors.put(field, message);
        }

        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.VALIDATION_ERROR.getCode(), ErrorCode.VALIDATION_ERROR.getMessage(), errors);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errorResponse);
    }

    // 찾은 행이 없을 때 예외 처리
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("entity", ex.getMessage());

        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.ENTITY_NOT_FOUND_ERROR.getCode(), ErrorCode.ENTITY_NOT_FOUND_ERROR.getMessage(), errors);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    // File 확장자 예외 처리
    @ExceptionHandler(FileUploadException.class)
    public ResponseEntity<ErrorResponse> handleFileUploadException(FileUploadException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("file", ex.getMessage());

        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.FILE_EXTENSION_ERROR.getCode(), ErrorCode.FILE_EXTENSION_ERROR.getMessage(), errors);
        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body(errorResponse);
    }

    // File 저장 예외 처리
    @ExceptionHandler(FileSaveException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("file", ex.getMessage());

        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.FILE_SAVE_ERROR.getCode(), ErrorCode.FILE_SAVE_ERROR.getMessage(), errors);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    // File 크기 예외 처리
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ErrorResponse> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("file", ex.getMessage());

        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.MAX_FILE_SIZE_ERROR.getCode(), ErrorCode.MAX_FILE_SIZE_ERROR.getMessage(), errors);
        return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).body(errorResponse);
    }
}
