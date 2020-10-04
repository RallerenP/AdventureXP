package com.adventurealley.adventurexp.services;

import com.adventurealley.adventurexp.dtos.LoginDTO;
import com.adventurealley.adventurexp.dtos.SignupDTO;
import com.adventurealley.adventurexp.entities.Role;
import com.adventurealley.adventurexp.entities.User;
import com.adventurealley.adventurexp.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findUserById(userId);
    }

    @Override
    public User createUser(SignupDTO signupDTO) {
        User userTmp = new User();
        userTmp.setUsername(signupDTO.getUsername());
        userTmp.setPassword(signupDTO.getPassword());
        userTmp.setEmail(signupDTO.getEmail());
        userTmp.setRole(Role.CUSTOMER);
        userTmp.setFirstName(signupDTO.getFirstName());
        userTmp.setLastName(signupDTO.getLastName());
        userRepository.save(userTmp);
        return userRepository.findByUsername(userTmp.getUsername());
    }

    @Override
    public User authenticateUser(LoginDTO loginDTO) {
        User u = userRepository.findByUsername(loginDTO.getUsername());
        if (u.getPassword().equals(loginDTO.getPassword())) {
            return u;
        } else {
            return null;
        }
    }
}
