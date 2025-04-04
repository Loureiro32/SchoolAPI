package com.mindera.school.exception;


public class HandleError {

    private int status;
    private String message;
    private String details;

    public HandleError(int status, String message, String details) {
        this.status = status;
        this.message = message;
        this.details = details;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
