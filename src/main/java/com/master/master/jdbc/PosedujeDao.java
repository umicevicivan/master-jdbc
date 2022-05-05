package com.master.master.jdbc;

import com.master.master.domain.Poseduje;
import com.master.master.jdbc.mapper.PosedujeRowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public class PosedujeDao extends AbstractDao {

    private final PosedujeRowMapper mapper;

    public PosedujeDao(PosedujeRowMapper mapper) {
        this.mapper = mapper;
    }

    public List<Poseduje> findAll() {
        String sql = "SELECT * FROM IVAN.POSEDUJE";
        return jdbcTemplate.query(sql, mapper);
    }

    public void insertAll() {
        String sql = "INSERT INTO IVAN.POSEDUJE VALUES(?, ?, ?, ?)";

        for (int i = 1; i < 60000; i++) {
            jdbcTemplate.update(sql, (int) ((Math.random() * (53 - 1) + 1)), (int) ((Math.random() * (50499 - 1) + 1)), new Timestamp(new Date().getTime()), new Timestamp(new Date().getTime()));
        }
    }
}
