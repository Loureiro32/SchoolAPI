package com.mindera.school.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(TeacherNotFoundException.class)
   public ResponseEntity<?> handleException(TeacherNotFoundException exception, WebRequest request) {
        HandleError errorDetails = new HandleError(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
   }


    @org.springframework.web.bind.annotation.ExceptionHandler(StudentNotFoundExecption.class)
    public ResponseEntity<?> handleException(StudentNotFoundExecption exception, WebRequest request ){
        HandleError handleError = new HandleError(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(handleError, HttpStatus.NOT_FOUND);
    }
}
