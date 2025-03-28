package com.mindera.school.mapper;

import com.mindera.school.dto.TeacherDto;
import com.mindera.school.entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface TeacherMapper {

    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    TeacherDto ToTeacherDto(Teacher teacher);

}
