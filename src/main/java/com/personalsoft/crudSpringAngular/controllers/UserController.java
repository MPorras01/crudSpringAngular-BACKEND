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

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<?> creaTorre(@RequestBody UserDto userDto){

        if(StringUtils.isBlank(userDto.getName()))
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

       /* if(torreService.existsByNombreTorre(torreDto.getNombreTorre()))
            return new ResponseEntity(new Mensaje("Ya existe una torre con ese nombre"), HttpStatus.BAD_REQUEST);*/

        Users user = new Users(userDto.getDocumentNumber(), userDto.getDocumentNumber(), userDto.getUserName(), userDto.getUserName(), userDto.getPassword() );

        userService.saveUser(user);

        return new ResponseEntity(new Message("Usario creado"), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Users>> findAllUsers(){

        List<Users> users = userService.findAll();

        return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
    }



}
