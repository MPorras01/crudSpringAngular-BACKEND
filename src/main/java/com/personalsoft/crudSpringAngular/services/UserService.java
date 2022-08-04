package com.personalsoft.crudSpringAngular.services;

import com.personalsoft.crudSpringAngular.models.UserDto;
import com.personalsoft.crudSpringAngular.models.Users;
import com.personalsoft.crudSpringAngular.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    IUserRepository iUserRepository;

    public void saveUser(Users user){
        iUserRepository.save(user);
    }

    public List<Users> findAll(){

        List<Users> users = iUserRepository.findAll();
        return users;
    }


}
