package com.mindera.school.controller;

import com.mindera.school.dto.StudentDto;
import com.mindera.school.dto.TeacherDto;
import com.mindera.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;


    @GetMapping(path= "{id}/personalinfo")
    public TeacherDto getPersonalInfo(Long id){
        return this.teacherService.getPersonalInfo(id);
    }

    @GetMapping(path = "/students")
    public List<StudentDto> getAllStudents(){
        return this.teacherService.getAllStudents();
    }

}
