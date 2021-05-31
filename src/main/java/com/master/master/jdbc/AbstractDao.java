package com.master.master.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

public abstract class AbstractDao {
    protected DataSource dataSource;
    protected JdbcTemplate jdbcTemplate;
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setDataSource(@Qualifier("dataSource") DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    protected int booleanToInt(boolean value) { return value ? 1 : 0; }
}
