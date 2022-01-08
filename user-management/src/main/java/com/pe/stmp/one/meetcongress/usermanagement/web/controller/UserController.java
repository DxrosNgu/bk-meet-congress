package com.pe.stmp.one.meetcongress.usermanagement.web.controller;

import com.pe.stmp.one.meetcongress.usermanagement.web.model.dao.User;
import com.pe.stmp.one.meetcongress.usermanagement.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RefreshScope
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/find-by-user",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> findByUsername (@RequestParam("user") String username){
        return new ResponseEntity<>(userService.findByUsername(username), HttpStatus.OK);
    }

    @PutMapping(value = "/users/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable Long id){
        return new ResponseEntity<>(userService.updateUser(user, id), HttpStatus.OK);
    }

}
