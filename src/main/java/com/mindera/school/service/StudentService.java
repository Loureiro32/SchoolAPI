package com.mindera.school.service;

import com.mindera.school.dto.StudentDto;
import com.mindera.school.mapper.StudentMapper;
import com.mindera.school.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentDto getPersonalInfo(Long id){
        return StudentMapper.INSTANCE.ToStudentDto(this.studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found")));
    }



    public StudentDto saveOrCreateAccount(StudentDto studentDto) {
        this.studentRepository.save(StudentMapper.INSTANCE.ToStudent(studentDto));
        return studentDto;
    }

}
