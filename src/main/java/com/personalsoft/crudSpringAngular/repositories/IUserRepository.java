package com.personalsoft.crudSpringAngular.repositories;

import com.personalsoft.crudSpringAngular.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository  extends JpaRepository<Users, Integer> {

    Optional<Users> findByUserName(String userName);
}
