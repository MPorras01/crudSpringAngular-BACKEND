package com.personalsoft.crudSpringAngular.controllers;


import com.personalsoft.crudSpringAngular.models.Message;
import com.personalsoft.crudSpringAngular.models.Users;
import com.personalsoft.crudSpringAngular.models.UserDto;
import com.personalsoft.crudSpringAngular.services.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user/")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    UserService userService;

    /*  @PostMapping()
      public ResponseEntity<?> createUser(@RequestBody UserDto userDto){

          if(StringUtils.isBlank(userDto.getName()))
              return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

          Users user = new Users(userDto.getDocumentNumber(), userDto.getDocumentNumber(), userDto.getUserName(), userDto.getUserName(), userDto.getPassword() );

          userService.saveUser(user);

          return new ResponseEntity(new Message("Usuario creado"), HttpStatus.OK);
      }*/
    @PostMapping()
    public ResponseEntity<Users> saveUser(@RequestBody Users user) {
        try {
            Users usersSave = userService.save(user);
            return ResponseEntity.created(new URI("/user/" + usersSave.getId())).body(usersSave);

        } catch (Exception e) {
            e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }


    @GetMapping()
    public ResponseEntity<List<Users>> findAllUsers() {

        List<Users> users = userService.findAll();

        return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Users> updateUser(@RequestBody Users user) {
        try {
            boolean existUser = userService.existUser(user);

            if (existUser) {

                Users usersSave = userService.save(user);
                return ResponseEntity.created(new URI("/user/" + usersSave.getId())).body(usersSave);
            }

            return new ResponseEntity<Users>(user, HttpStatus.NOT_FOUND);

        } catch (Exception e) {

            e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
