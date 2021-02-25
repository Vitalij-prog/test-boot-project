package org.vital.bootproject.api;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.vital.bootproject.model.Person;
import org.vital.bootproject.service.PersonService;

import java.util.List;

@RequestMapping("/api/v1/person")
@RestController
public class PersonController {
    private final PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        service.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return service.selectPeople();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") int id) {
        return service.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") int id) {
        service.deletePersonById(id);
    }

    @PutMapping(path = "{id}")
    public void updatePersonById(@PathVariable("id") int id, @RequestBody Person person) {
        service.updatePersonById(id, person);
    }

}
