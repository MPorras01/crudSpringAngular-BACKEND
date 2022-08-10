package com.personalsoft.crudSpringAngular.services;

import com.personalsoft.crudSpringAngular.models.Person;
import com.personalsoft.crudSpringAngular.repositories.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonService {

    @Autowired
    IPersonRepository iPersonRepository;


    public <T extends Person> T save(T entity) {

        return iPersonRepository.save(entity);
    }

    public List<Person> findAll() {

        List<Person> personList = iPersonRepository.findAll();
        return personList;
    }

    public <T extends Person> Optional<Person> findPersonByPersonalId(Person person) {

        Optional<Person> optionalPersons = iPersonRepository.findById(person.getId());

        return optionalPersons;
    }
    public boolean existPerson(int id) {
        return iPersonRepository.existsById(id);
    }

    public void deletePerson(int id) {

        iPersonRepository.deleteById(id);
    }

    public Person findPersonById(Integer id) {

        Person person = iPersonRepository.findById(id).orElse(null);
        return person;
    }

}
