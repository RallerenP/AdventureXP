package com.adventurealley.adventurexp.services;

import com.adventurealley.adventurexp.dtos.UserDTO;
import com.adventurealley.adventurexp.entities.User;
import com.adventurealley.adventurexp.repositories.IRepository;

import java.util.List;

public class UserService implements IUserService{
    IRepository<User, UserDTO> userRepository;

    public void UserService(IRepository userRepository){

    }

    @Override
    public User getUserByUsername(String username) {
        List<User> users = userRepository.readAll();
        for(User user : users){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.read(userId);
    }
}
