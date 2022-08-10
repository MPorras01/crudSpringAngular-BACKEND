package com.personalsoft.crudSpringAngular.controllers;
import com.personalsoft.crudSpringAngular.models.Person;
import com.personalsoft.crudSpringAngular.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/person/")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping()
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        try {
            Person personSave = personService.save(person);

            return ResponseEntity.created(new URI("/person/" + personSave.getId())).body(personSave);

        } catch (Exception e) {
            e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<Person>> findAllPersons() {

        List<Person> personList = personService.findAll();

        return new ResponseEntity<List<Person>>(personList, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
        try {
            boolean existPerson= personService.existPerson(person.getId());

            if (existPerson) {

                Person personSave = personService.save(person);
                return ResponseEntity.created(new URI("/person/" + personSave.getId())).body(personSave);
            }

            return new ResponseEntity<Person>(person, HttpStatus.NOT_FOUND);

        } catch (Exception e) {

            e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable(name = "id") int id) {

        try {
            boolean existPerson = personService.existPerson(id);
            Person person = personService.findPersonById(id);

            if (existPerson) {
                personService.deletePerson(id);
                return new ResponseEntity<Person>(person, HttpStatus.OK);
            }

            return new ResponseEntity<Person>(person, HttpStatus.NOT_FOUND);

        } catch (Exception e) {

            e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


}
