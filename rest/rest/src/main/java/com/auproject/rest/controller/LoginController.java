package com.auproject.rest.controller;

import com.auproject.rest.model.UserInformation;
import com.auproject.rest.service.UserInformationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

// Class capital
//method camel case

@RestController
public class LoginController {

    @Autowired
    private UserInformationServices services;

    @PostMapping("/login")
    @CrossOrigin("*")
    public ResponseEntity<String> loginCheck(@RequestBody UserInformation user){
        return  new ResponseEntity<>(this.services.login(user), HttpStatus.OK);
    }

    @PostMapping("/register")
    @CrossOrigin("*")
    public  ResponseEntity<String> registerUser(@RequestBody UserInformation user){
        return new ResponseEntity<>(this.services.register(user),HttpStatus.OK);
    }

    @PutMapping("/user/update")
    @CrossOrigin("*")
    public ResponseEntity<Boolean> updateUSer(@RequestBody UserInformation user){
        return  new ResponseEntity<>(this.services.updateUser(user), HttpStatus.OK);
    }

    @GetMapping("/user/details/{userId}")
    @CrossOrigin("*")
    public Optional<UserInformation> getDetails(@PathVariable int userId){
        return  this.services.getUser(userId);
    }

}


