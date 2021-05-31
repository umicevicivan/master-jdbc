package com.master.master.jdbc.mapper;

import com.master.master.domain.Drzava;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class DrzavaRowMapper extends AbstractRowMapper<Drzava> {

    @Override
    protected Drzava mapRow() throws SQLException {
        Drzava d = new Drzava();
        d.setId(getInteger("id"));
        d.setNaziv(getString("naziv"));
        d.setSkraceniNaziv(getString("skraceni_naziv"));
        d.setBrojStanovnika(getInteger("broj_stanovnika"));

        return d;
    }
}
