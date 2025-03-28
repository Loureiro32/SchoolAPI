package com.mindera.school.service;

import com.mindera.school.dto.StudentDto;
import com.mindera.school.dto.TeacherDto;
import com.mindera.school.mapper.StudentMapper;
import com.mindera.school.mapper.TeacherMapper;
import com.mindera.school.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    public TeacherDto getPersonalInfo(Long id){
        return TeacherMapper.INSTANCE.ToTeacherDto(this.teacherRepository.findById(id).orElseThrow(() -> new RuntimeException("Teacher not found")));
    }

    public List<StudentDto> getAllStudents(){
        return this.teacherRepository.findAll().stream().map(StudentMapper.INSTANCE::ToStudentDtoList).collect(Collectors.toList());
    }

}
