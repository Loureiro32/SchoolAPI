package com.mindera.school.controller;

import com.mindera.school.dto.StudentDto;
import com.mindera.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

 @Autowired
 StudentService studentService;


 @GetMapping(path = "/{id}/personalinfo")
    public StudentDto getPersonalInfo(@PathVariable Long id){
     return this.studentService.getPersonalInfo(id);
 }



}
