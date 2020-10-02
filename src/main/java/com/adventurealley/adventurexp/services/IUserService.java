package com.adventurealley.adventurexp.services;

import com.adventurealley.adventurexp.dtos.LoginDTO;
import com.adventurealley.adventurexp.dtos.SignupDTO;
import com.adventurealley.adventurexp.dtos.UserDTO;
import com.adventurealley.adventurexp.entities.User;

public interface IUserService {
    public User createUser(SignupDTO signupDTO);
    public User getUserByUsername(String username);
    public User getUserById(Long userId);
}
