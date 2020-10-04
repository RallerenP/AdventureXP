package com.adventurealley.adventurexp.controllers;

import com.adventurealley.adventurexp.dtos.LoginDTO;
import com.adventurealley.adventurexp.dtos.SignupDTO;
import com.adventurealley.adventurexp.entities.User;
import com.adventurealley.adventurexp.services.IUserService;
import com.adventurealley.adventurexp.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    String loginScreen() {
        return "login";
    }

    @PostMapping("/api/signup")
    ResponseEntity<String> signup(@RequestBody SignupDTO signupDTO) {
        //Create DTO and send down to DB through service layer
        userService.createUser(signupDTO);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @GetMapping("/api/login")
    ResponseEntity<String> login(@RequestBody LoginDTO loginDTO, HttpSession session) {
        User u = userService.authenticateUser(loginDTO);
        if (u == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            session.setAttribute("user", u);
            return new ResponseEntity<>(u.toString(), HttpStatus.OK);
        }
    }

}
