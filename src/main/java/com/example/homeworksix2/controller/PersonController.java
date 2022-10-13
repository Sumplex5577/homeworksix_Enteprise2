package com.example.homeworksix2.controller;

import com.example.homeworksix2.dto.PersonDto;
import com.example.homeworksix2.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String personIndex(Model model) {
        String message = "Person control page";
        model.addAttribute("message", message);
        return "personIndex";
    }
    @RequestMapping(value = "/add_person", method = RequestMethod.GET)
    public String addPersonView(Model model) {
        model.addAttribute("person", new PersonDto());
        return "addPerson";
    }

    @RequestMapping(value = "/add_person", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") PersonDto personDto) {
        personService.addPerson(personDto);
        return "addPersonSuccess";
    }

    @RequestMapping(value = "/remove_person", method = RequestMethod.GET)
    public String removePersonByIdView(Model model) {
        model.addAttribute("person", new PersonDto());
        return "removePerson";
    }

    @RequestMapping(value = "/remove_person", method = {RequestMethod.DELETE, RequestMethod.POST})
    @Transactional
    public String removePersonById(@ModelAttribute("person") PersonDto personDto) {
        personService.removePersonById(personDto.getId());
        return "removePersonSuccess";
    }

    @GetMapping( "/all_persons")
    public String getAllPersons(Model model) {
        model.addAttribute("all", personService.getAllPersons());
        return "allPersons";
    }

    @RequestMapping(value = "/update_first_name", method = RequestMethod.GET)
    public String updatePersonFirstNameByIdView(Model model) {
        model.addAttribute("person", new PersonDto());
        return "updatePersonFirstName";
    }

    @RequestMapping(value = "/update_first_name", method = {RequestMethod.PUT, RequestMethod.POST})
    @Transactional
    public String updatePersonFirstNameById(@ModelAttribute("person") PersonDto personDto) {
        personService.updatePersonFirstNameById(personDto.getId(), personDto);
        return "updatePersonFirstNameSuccess";
    }

    @RequestMapping(value = "/update_last_name", method = RequestMethod.GET)
    public String updatePersonLastNameByIdView(Model model) {
        model.addAttribute("person", new PersonDto());
        return "updatePersonLastName";
    }

    @RequestMapping(value = "/update_last_name", method = {RequestMethod.PUT, RequestMethod.POST})
    @Transactional
    public String updatePersonLastNameById(@ModelAttribute("person") PersonDto personDto) {
        personService.updatePersonLastNameById(personDto.getId(), personDto);
        return "updatePersonLastNameSuccess";
    }

    @RequestMapping(value = "/update_phone_number", method = RequestMethod.GET)
    public String updatePersonPhoneNumberByIdView(Model model) {
        model.addAttribute("person", new PersonDto());
        return "updatePersonPhoneNumber";
    }

    @RequestMapping(value = "/update_phone_number", method = {RequestMethod.PUT, RequestMethod.POST})
    @Transactional
    public String updatePersonPhoneNumberById(@ModelAttribute("person") PersonDto personDto) {
        personService.updatePersonPhoneNumberById(personDto.getId(), personDto);
        return "updatePersonPhoneNumberSuccess";
    }
}