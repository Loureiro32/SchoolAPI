package com.mindera.school.mapper;

import com.mindera.school.dto.PersonDto;
import com.mindera.school.entity.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PersonMapper{

    PersonDto toPersonDto(Person person);

    Person toPerson(PersonDto personDto);

    List<PersonDto> toPersonDtoList(List<Person> personList);

    List<Person> toPersonList(List<PersonDto> personDtoList);
}
