package com.example.homeworksix.service;

import com.example.homeworksix.dto.PersonDto;
import com.example.homeworksix.model.Person;
import com.example.homeworksix.utils.exception.NotFoundException;

import java.util.List;

public interface PersonService {
    PersonDto addPerson(PersonDto dto);

    PersonDto removePersonById(Long id);

    PersonDto getPersonById(Long id);

    List<PersonDto> getAllPersons();

    Long updatePersonFirstNameById(Long id, PersonDto dto);

    Long updatePersonLastNameById(Long id, PersonDto dto);

    Long updatePersonPhoneNumberById(Long id, PersonDto dto);
}
