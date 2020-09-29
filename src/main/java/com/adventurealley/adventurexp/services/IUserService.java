package com.adventurealley.adventurexp.services;

import com.adventurealley.adventurexp.entities.User;

public interface IUserService {
    public User getUserByUsername(String username);
    public User getUserById(int userId);
}
