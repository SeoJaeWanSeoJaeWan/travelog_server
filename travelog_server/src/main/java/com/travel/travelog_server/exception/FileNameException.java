package com.travel.travelog_server.exception;

public class FileNameException extends IllegalStateException {
    public FileNameException(String message) {
        super(message);
    }

    public FileNameException(String message, Throwable cause) {
        super(message, cause);
    }
}
