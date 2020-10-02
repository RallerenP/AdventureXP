package com.adventurealley.adventurexp.repositories;

import com.adventurealley.adventurexp.dtos.LoginDTO;
import com.adventurealley.adventurexp.dtos.UserDTO;
import com.adventurealley.adventurexp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    //Already contains 'save' method
    User findUserById(Long id);
    User findByUsername(String username);



}
