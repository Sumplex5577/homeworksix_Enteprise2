package com.example.homeworksix.converter;

import com.example.homeworksix.dto.PersonDto;
import com.example.homeworksix.model.Person;

public class PersonConverter {

    public static PersonDto convertPersonToPersonDto(Person person) {
        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setFirstName(person.getFirstName());
        personDto.setLastName(person.getLastName());
        personDto.setPhoneNumber(person.getPhoneNumber());
        personDto.setCarts(person.getCarts());
        return personDto;
    }

    public static Person convertPersonDtoToPerson(PersonDto personDto) {
        Person person = new Person();
        person.setId(personDto.getId());
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setPhoneNumber(personDto.getPhoneNumber());
        person.setCarts(personDto.getCarts());
        return person;
    }
}

