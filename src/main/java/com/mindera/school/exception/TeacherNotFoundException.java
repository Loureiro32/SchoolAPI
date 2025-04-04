package com.mindera.school.exception;

public class TeacherNotFoundException extends RuntimeException {

    public TeacherNotFoundException(String message){
        super(message);
    }

    public TeacherNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
    }
}
