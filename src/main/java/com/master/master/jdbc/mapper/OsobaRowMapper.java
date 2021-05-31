package com.master.master.jdbc.mapper;

import com.master.master.domain.Osoba;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class OsobaRowMapper extends AbstractRowMapper<Osoba> {
    @Override
    protected Osoba mapRow() throws SQLException {
        Osoba o = new Osoba();
        o.setId(getInteger("id"));
        o.setIme(getString("ime"));
        o.setPrezime(getString("prezime"));
        o.setGodine(getInteger("godine"));
        o.setPol(getString("pol"));

        return o;
    }

}
