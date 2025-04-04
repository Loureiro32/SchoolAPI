package com.mindera.school.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalValidationException{
    @org.springframework.web.bind.annotation.ExceptionHandler(ValidationException.class)
    public ResponseEntity<HandleError> handleValidationException(ValidationException ex) {
        HandleError error = new HandleError(
                HttpStatus.BAD_REQUEST.value(),
                "Validation Error",
                ex.getMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(StudentNotFoundExecption.class)
    public ResponseEntity<HandleError> handleStudentNotFoundException(StudentNotFoundExecption ex) {
        HandleError error = new HandleError(
                HttpStatus.NOT_FOUND.value(),
                "Student not found",
                ex.getMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TeacherNotFoundException.class)
    public ResponseEntity<HandleError> handleTeacherNotFoundException(TeacherNotFoundException ex) {
        HandleError error = new HandleError(
                HttpStatus.NOT_FOUND.value(),
                "Teacher not found",
                ex.getMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
