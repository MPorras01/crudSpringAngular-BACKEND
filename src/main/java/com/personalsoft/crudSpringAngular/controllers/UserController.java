package com.personalsoft.crudSpringAngular.controllers;
import com.personalsoft.crudSpringAngular.models.UserDtoLogin;
import com.personalsoft.crudSpringAngular.models.Users;
import com.personalsoft.crudSpringAngular.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    UserService userService;

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
            boolean existUser = userService.existUser(user.getId());

            if (existUser) {

                Users userUpdate = userService.save(user);
                return ResponseEntity.created(new URI("/user/" + userUpdate.getId())).body(userUpdate);
            }

            return new ResponseEntity<Users>(user, HttpStatus.NOT_FOUND);

        } catch (Exception e) {

            e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Users> deleteUser(@PathVariable(name = "id") int id) {

        try {
            boolean existUser = userService.existUser(id);
            Users user = userService.findUserById(id);

            if (existUser) {
                userService.deleteUser(id);
                return new ResponseEntity<Users>(user, HttpStatus.OK);
            }

            return new ResponseEntity<Users>(user, HttpStatus.NOT_FOUND);

        } catch (Exception e) {

            e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("login")
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody UserDtoLogin userDtoLogin) {

            Map<String, Object> usersSave = userService.findUserByUserName(userDtoLogin);

            return ResponseEntity.ok(usersSave);

    }

}
