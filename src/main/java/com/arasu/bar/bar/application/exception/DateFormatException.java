package com.arasu.bar.bar.application.exception;

public class DateFormatException extends RuntimeException {
    public DateFormatException() {
        super();
    }

    public DateFormatException(String message) {
        super(message);
    }

    public DateFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public DateFormatException(Throwable cause) {
        super(cause);
    }
}
