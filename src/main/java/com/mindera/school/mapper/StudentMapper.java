package com.mindera.school.mapper;

import com.mindera.school.dto.StudentDto;
import com.mindera.school.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDto ToStudentDto(Student student);

    List<StudentDto> ToStudentDtoList(List<Student> student);

    Student ToStudent(StudentDto studentDto);
}
