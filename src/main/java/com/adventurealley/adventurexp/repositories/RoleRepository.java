package com.adventurealley.adventurexp.repositories;

import com.adventurealley.adventurexp.entities.Role;
import com.adventurealley.adventurexp.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;

@Repository
public class RoleRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SqlRowSet sqlRowSet;

    public Role getRoleById(int id) {

        String sql = "SELECT * FROM role WHERE id = " + id;
        sqlRowSet = jdbcTemplate.queryForRowSet(sql);

        return load(sqlRowSet);
    }

    private Role load(SqlRowSet rs) {
        return Role.parse(rs.getString("name"));
    }


}
