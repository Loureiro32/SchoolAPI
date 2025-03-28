package com.mindera.school.service;

import com.mindera.school.dto.StudentDto;
import com.mindera.school.mapper.StudentMapper;
import com.mindera.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;


    public StudentDto getPersonalInfo(Long id){
        return StudentMapper.INSTANCE.ToStudentDto(this.studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found")));
    }

}
