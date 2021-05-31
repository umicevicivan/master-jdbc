package com.master.master.jdbc.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public abstract class AbstractRowMapper<T> implements RowMapper<T> {

    private ResultSet rs;
    protected abstract T mapRow() throws SQLException;

    public AbstractRowMapper(){

    }

    public T mapRow(ResultSet rs, int rowNumber) throws SQLException {
        this.rs = rs;
        return mapRow();
    }

    public ResultSet getResultSet() {
        return rs;
    }

    protected Integer getInteger(String columnLabel) throws SQLException {
        Integer value = rs.getInt(columnLabel);
        return rs.wasNull() ? null : value;
    }

    protected String getString(String columnLabel) throws SQLException {
        return rs.getString(columnLabel);
    }

    protected Timestamp getTimestamp(String columnLabel) throws SQLException {
        return rs.getTimestamp(columnLabel);
    }

    protected LocalDateTime getLocalDateTime(String columnLabel) throws SQLException {
        Timestamp ts = getTimestamp(columnLabel);
        return ts != null ? ts.toLocalDateTime() : null;
    }

    protected Boolean getBooleanFromInt(String columnLabel) throws SQLException {
        return rs.getInt(columnLabel) == 1;
    }

    protected BigDecimal getBigDecimal(String columnLabel) throws SQLException {
        return  rs.getBigDecimal(columnLabel);
    }

}
