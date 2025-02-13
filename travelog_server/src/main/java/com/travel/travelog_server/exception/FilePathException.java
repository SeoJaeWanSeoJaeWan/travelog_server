package com.travel.travelog_server.exception;

public class FilePathException extends IllegalStateException {
    public FilePathException(String message) {
        super(message);
    }

    public FilePathException(String message, Throwable cause) {
        super(message, cause);
    }
}
