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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RestController
public class UserController {

    IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/users/signup")
    ResponseEntity<String> signup(@RequestBody SignupDTO signupDTO) {
        //Create DTO and send down to DB through service layer
        userService.createUser(signupDTO);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @GetMapping("/api/users")
    ResponseEntity<String> getUser(HttpSession session) {
        User u = (User) session.getAttribute("user");
        if (u == null) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        else return new ResponseEntity<>(u.toJSON().toString(), HttpStatus.OK);
    }

    @PostMapping("/api/users/login")
    ResponseEntity<String> login(@RequestBody LoginDTO loginDTO, HttpSession session, HttpServletResponse response) {
        User u = userService.authenticateUser(loginDTO);
        if (u == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            session.setAttribute("user", u);
            return new ResponseEntity<>(u.toJSON().toString(), HttpStatus.OK);
        }
    }

    @GetMapping("/api/users/logout")
    ResponseEntity<String> logout(HttpSession session) {
        session.removeAttribute("user");
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
