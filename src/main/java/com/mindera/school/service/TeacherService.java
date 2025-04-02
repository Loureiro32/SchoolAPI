package com.mindera.school.service;

import com.mindera.school.dto.StudentDto;
import com.mindera.school.dto.TeacherDto;
import com.mindera.school.mapper.StudentMapper;
import com.mindera.school.mapper.TeacherMapper;
import com.mindera.school.repository.StudentRepository;
import com.mindera.school.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TeacherService {

    TeacherRepository teacherRepository;
    StudentRepository studentRepository;

    public TeacherService(TeacherRepository teacherRepository, StudentRepository studentRepository) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
    }

    public TeacherDto getPersonalInfo(Long id){
        return TeacherMapper.INSTANCE.ToTeacherDto(this.teacherRepository.findById(id).orElseThrow(() -> new RuntimeException("Teacher not found")));
    }

    public List<StudentDto> getAllStudents(){
        return StudentMapper.INSTANCE.ToStudentDtoList(this.studentRepository.findAll());
    }

    public TeacherDto saveOrCreateTeacher(TeacherDto teacherDto){
        this.teacherRepository.save(TeacherMapper.INSTANCE.ToTeacher(teacherDto));
      return teacherDto;
    }


}
