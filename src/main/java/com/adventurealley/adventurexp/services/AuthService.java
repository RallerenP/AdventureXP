package com.adventurealley.adventurexp.services;

import com.adventurealley.adventurexp.dtos.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService{
    IUserService userService = new UserService();

    public void AuthService(IUserService userService){

    }

    @Override
    public void signup(UserDTO userDto) {

    }

    @Override
    public void login() {

    }
}
