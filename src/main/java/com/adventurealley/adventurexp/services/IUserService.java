package com.adventurealley.adventurexp.services;

import com.adventurealley.adventurexp.dtos.LoginDTO;
import com.adventurealley.adventurexp.dtos.SignupDTO;
import com.adventurealley.adventurexp.dtos.UserDTO;
import com.adventurealley.adventurexp.entities.User;

public interface IUserService {
    User createUser(SignupDTO signupDTO);
    User authenticateUser(LoginDTO loginDTO);
    User getUserByUsername(String username);
    User getUserById(Long userId);

}
