package com.personalsoft.crudSpringAngular.repositories;

import com.personalsoft.crudSpringAngular.models.Person;
import com.personalsoft.crudSpringAngular.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Integer> {
}
