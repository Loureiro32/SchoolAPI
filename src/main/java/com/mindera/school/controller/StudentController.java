package com.mindera.school.controller;

import com.mindera.school.dto.StudentDto;
import com.mindera.school.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

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
   return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }
  return ResponseEntity.ok(this.studentService.saveOrCreateAccount(studentDto));
 }

}
