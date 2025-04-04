package com.mindera.school.controller;

import com.mindera.school.dto.StudentDto;
import com.mindera.school.exception.ValidationException;
import com.mindera.school.service.StudentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

 private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

 StudentService studentService;

 public StudentController(StudentService studentService) {
  this.studentService = studentService;
 }

 @GetMapping(path = "/{id}/personalinfo")
    public StudentDto getPersonalInfo(@PathVariable Long id){
     return this.studentService.getPersonalInfo(id);
 }

 @PostMapping
 public ResponseEntity<StudentDto> createAccount(@Valid @RequestBody StudentDto studentDto, BindingResult bindingResult) {
  if (bindingResult.hasErrors()) {
   String errors = bindingResult.getAllErrors()
           .stream()
           .map(error -> error.getDefaultMessage())
           .collect(Collectors.joining(", ")
   );

   logger.error("Validation error in createStudent: {}", errors);
   throw new ValidationException("Validation Error: " + errors);
   }
  return ResponseEntity.ok(this.studentService.saveOrCreateAccount(studentDto));
 }


}
