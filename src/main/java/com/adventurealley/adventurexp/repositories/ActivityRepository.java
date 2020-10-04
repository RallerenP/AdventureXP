package com.adventurealley.adventurexp.repositories;

import com.adventurealley.adventurexp.dtos.ActivityDTO;
import com.adventurealley.adventurexp.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
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

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    Activity getById(long id);
}
