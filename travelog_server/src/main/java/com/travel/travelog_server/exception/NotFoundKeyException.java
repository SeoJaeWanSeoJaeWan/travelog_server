package com.travel.travelog_server.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundKeyException extends EntityNotFoundException {
    public NotFoundKeyException(String message) {
        super(message);
    }
}
