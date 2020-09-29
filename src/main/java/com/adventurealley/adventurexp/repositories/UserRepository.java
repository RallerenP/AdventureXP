package com.adventurealley.adventurexp.repositories;


import com.adventurealley.adventurexp.dtos.UserDTO;
import com.adventurealley.adventurexp.entities.Role;
import com.adventurealley.adventurexp.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IRepository<User, UserDTO> {

    private JdbcTemplate jdbcTemplate;
    private SqlRowSet sqlRowSet;
    private RoleRepository roleRepository;

    public UserRepository(RoleRepository roleRepository, JdbcTemplate jdbcTemplate) {
        this.roleRepository = roleRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User create(UserDTO dto) {
        String username = dto.getUsername();
        String password = dto.getPassword();
        String email = dto.getEmail();
        int roleID = Role.getID(Role.parse(dto.getRole()));
        String sql = "INSERT INTO user(username, password, email, roleID) VALUES('" + username + "','" +password + "','" + email + "','" + roleID + "')";
        jdbcTemplate.execute(sql);

        sql = "SELECT * FROM user WHERE username = " + username;
        sqlRowSet = jdbcTemplate.queryForRowSet(sql);

        return load(sqlRowSet);
    }

    @Override
    public User read(int id) {
        String sql = "SELECT * FROM user WHERE id = " + id;
        sqlRowSet = jdbcTemplate.queryForRowSet(sql);

        return load(sqlRowSet);
    }

    @Override
    public List<User> readAll() {
        String sql = "SELECT * FROM user";
        sqlRowSet =jdbcTemplate.queryForRowSet(sql);

        ArrayList<User> tmp = new ArrayList<>();
        while (sqlRowSet.next()) {
            tmp.add(load(sqlRowSet));
        }
        return tmp;
    }

    @Override
    public User update(UserDTO dto) {
        return null;
    }

    @Override
    public boolean delete(UserDTO dto) {

        return true;
    }

    private User load(SqlRowSet rs) {
        return new User(
            rs.getString("username"),
            rs.getString("password"),
            roleRepository.getRoleById(rs.getInt("id")),
            rs.getString("email"),
            rs.getInt("id")
        );
    }
}
