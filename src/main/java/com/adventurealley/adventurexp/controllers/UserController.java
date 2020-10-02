package com.adventurealley.adventurexp.controllers;

import com.adventurealley.adventurexp.dtos.SignupDTO;
import com.adventurealley.adventurexp.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    UserService us;

    public UserController(UserService userController) {
        this.us = userController;
    }

    @GetMapping("/login")
    String loginScreen() {
        return "login";
    }

    @PostMapping("/api/signup")
    ResponseEntity<String> signup(@RequestBody SignupDTO signupDTO) {
        //Create DTO and send down to DB through service layer
        us.createUser(signupDTO);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @PostMapping("/api/login")
    String login() {
        return "index";
    }

}
