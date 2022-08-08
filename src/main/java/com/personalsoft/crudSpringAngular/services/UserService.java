package com.personalsoft.crudSpringAngular.services;

import com.personalsoft.crudSpringAngular.models.Users;
import com.personalsoft.crudSpringAngular.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    IUserRepository iUserRepository;

   /* public void saveUser(Users user){
        iUserRepository.save(user);
    }*/

    public <T extends Users> T save(T entity) {

        return iUserRepository.save(entity);
    }

    public List<Users> findAll() {

        List<Users> users = iUserRepository.findAll();
        return users;
    }

    public <T extends Users> Optional<Users> findUserByPersonalId(Users user) {

        Optional<Users> users = iUserRepository.findById(user.getId());

        return users;
    }
    public boolean existUser(int id) {
        return iUserRepository.existsById(id);
    }

    public void deleteUser(int id) {

        iUserRepository.deleteById(id);
    }

    public Users findUserById(Integer id) {

        Users user = iUserRepository.findById(id).orElse(null);
        return user;
    }

}
