package com.adventurealley.adventurexp.services;

import com.adventurealley.adventurexp.dtos.UserDTO;

public interface IAuthService {
    public void signup(UserDTO userDto);
    public void login(/*LoginDTO loginDto*/);
}
