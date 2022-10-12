package com.example.homeworksix2.service;

import com.example.homeworksix2.dto.PersonDto;

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
