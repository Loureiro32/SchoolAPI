package com.mindera.school.exception;

public class StudentNotFoundExecption  extends  RuntimeException{
    public StudentNotFoundExecption(String message){
        super(message);
    }

    public StudentNotFoundExecption(String resourceName, String fieldName, Object fieldValue){
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
    }
}
