package com.example.homeworksix.service;

import com.example.homeworksix.dto.PersonDto;
import com.example.homeworksix.model.Person;
import com.example.homeworksix.utils.exception.NotFoundException;

import java.util.List;

public interface PersonService {

    PersonDto createPerson(PersonDto personDto);

    PersonDto getPersonById(Long id) throws NotFoundException;

    PersonDto updatePerson(PersonDto personDto);

    void deletePerson(Long id) throws NotFoundException;

    List<PersonDto> getAllPersons();
}