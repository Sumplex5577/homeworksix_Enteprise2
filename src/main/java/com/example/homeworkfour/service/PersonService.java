package com.example.homeworkfour.service;

import com.example.homeworkfour.model.Person;
import com.example.homeworkfour.utils.exception.NotFoundException;

import java.util.List;

public interface PersonService {

    Person createPerson(Person person);

    Person getPersonById(Long id) throws NotFoundException;

    Person updatePerson(Long Id, Person person);

    Long deletePerson(Long id) throws NotFoundException;

    List<Person> getAllPersons();
}
