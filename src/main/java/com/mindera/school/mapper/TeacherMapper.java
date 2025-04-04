package com.mindera.school.mapper;

import com.mindera.school.dto.TeacherDto;
import com.mindera.school.entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface TeacherMapper {

    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    TeacherDto ToTeacherDto(Teacher teacher);

    Teacher ToTeacher(TeacherDto teacherDto);

    List<TeacherDto> ToTeacherDtoList(List<Teacher> teacherList);

    List<Teacher> ToTeacherList(List<TeacherDto> teacherDtoList);

}
