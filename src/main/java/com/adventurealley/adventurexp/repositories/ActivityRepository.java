package com.adventurealley.adventurexp.repositories;

import com.adventurealley.adventurexp.dtos.ActivityDTO;
import com.adventurealley.adventurexp.entities.Activity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;
import java.util.List;

@Repository
public class ActivityRepository implements IRepository<Activity, ActivityDTO> {

    private JdbcTemplate jdbcTemplate;
    private SqlRowSet sqlRowSet;

    public ActivityRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Activity create(ActivityDTO dto) {

        String sql = "INSERT INTO activity(name, minAge, minHeightCm, minPeriodMin, price, startTime, endTime) VALUES (?,?,?,?,?,?,?)";
        KeyHolder kh = new GeneratedKeyHolder();
        Timestamp startTime = null, endTime = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            Date start = dateFormat.parse(dto.getStartTime());
            Date end = dateFormat.parse(dto.getEndTime());
            startTime = new Timestamp(start.getTime());
            endTime = new Timestamp(end.getTime());
        } catch (Exception e) {
        }
        Timestamp finalEndTime = endTime;
        Timestamp finalStartTime = startTime;
        int rows = jdbcTemplate.update(connection -> {
            PreparedStatement ps =  connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, dto.getName());
            ps.setInt(2, dto.getMinAge());
            ps.setInt(3, dto.getMinAge());
            ps.setInt(4, dto.getMinPeriodMin());
            ps.setDouble(5, dto.getPrice());
            ps.setTimestamp(6, finalStartTime);
            ps.setTimestamp(7, finalEndTime);
            return ps;
        }, kh);

        if (rows == 0) {
            return null;
        }
        else {
            return read(kh.getKey().intValue());
        }
    }

    @Override
    public Activity read(int id) {
        String sql = "SELECT * FROM user WHERE id = " + id;
        sqlRowSet = jdbcTemplate.queryForRowSet(sql);

        return load(sqlRowSet);
    }

    @Override
    public List<Activity> readAll() {
        String sql = "SELECT * FROM user ";
        sqlRowSet = jdbcTemplate.queryForRowSet(sql);

        List<Activity> tmp = new ArrayList<>();
        while (sqlRowSet.next()) {
            tmp.add(load(sqlRowSet));
        }
        return tmp;
    }

    @Override
    public Activity update(ActivityDTO dto) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    private Activity load(SqlRowSet rs) {
        return new Activity(
                rs.getString("name"),
                rs.getInt("minAge"),
                rs.getInt("minHeightCm"),
                rs.getInt("minPeriodMin"),
                rs.getDouble("price"),
                rs.getTimestamp("startTime").toLocalDateTime(),
                rs.getTimestamp("endTime").toLocalDateTime()
        );
    }
}
