package com.example.homeworksix.controller;

import com.example.homeworksix.dto.PersonDto;
import com.example.homeworksix.model.Person;
import com.example.homeworksix.service.PersonService;
import com.example.homeworksix.utils.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public PersonDto createPerson(@RequestBody PersonDto personDto){
        return personService.createPerson(personDto);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public PersonDto getPersonById(@RequestParam Long id) throws NotFoundException {
        return personService.getPersonById(id);
    }

    @PutMapping ("/update")
    @ResponseStatus(HttpStatus.OK)
    public PersonDto updatePerson(@RequestBody PersonDto personDto) {
        return personService.updatePerson(personDto);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@RequestParam Long id) throws NotFoundException {
        personService.deletePerson(id);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<PersonDto> getAll() {
        return personService.getAllPersons();
    }
}
