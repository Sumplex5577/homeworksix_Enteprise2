package com.example.homeworksix2.service;

import com.example.homeworksix2.dto.PersonDto;
import com.example.homeworksix2.model.Person;
import com.example.homeworksix2.repository.PersonRepository;
import com.example.homeworksix2.utils.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.homeworksix2.converter.PersonConverter.convertPersonToPersonDto;


@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public PersonDto addPerson(PersonDto dto) {
        return convertPersonToPersonDto(personRepository.save(new Person(dto.getFirstName(), dto.getLastName(), dto.getPhoneNumber())));
    }

    @Override
    public PersonDto removePersonById(Long id) {
        if (personRepository.existsById(id)) {
            PersonDto personDto = convertPersonToPersonDto(personRepository.findById(id).get());
            personRepository.deleteById(id);
            return personDto;
        }
        try {
            throw new NotFoundException("Person with ID #" + id + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public PersonDto getPersonById(Long id) {
        if (personRepository.findById(id).isPresent()) {
            return convertPersonToPersonDto(personRepository.findById(id).get());
        }
        try {
            throw new NotFoundException("Person with ID #" + id + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<PersonDto> getAllPersons() {
        List<PersonDto> personDtoList = new ArrayList<>();
        personRepository.findAll().forEach(person -> personDtoList.add(convertPersonToPersonDto(person)));
        return personDtoList;
    }

    @Override
    public Long updatePersonFirstNameById(Long id, PersonDto dto) {
        if (personRepository.existsById(id)) {
            return Long.valueOf(personRepository.updatePersonFirstNameById(id, dto.getFirstName()));
        }
        try {
            throw new NotFoundException("Person with ID #" + id + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Long updatePersonLastNameById(Long id, PersonDto dto) {
        if (personRepository.existsById(id)) {
            return Long.valueOf(personRepository.updatePersonLastNameById(id, dto.getLastName()));
        }
        try {
            throw new NotFoundException("Person with ID #" + id + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Long updatePersonPhoneNumberById(Long id, PersonDto dto) {
        if (personRepository.existsById(id)) {
            return Long.valueOf(personRepository.updatePersonPhoneNumberById(id, dto.getPhoneNumber()));
        }
        try {
            throw new NotFoundException("Person with ID #" + id + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
