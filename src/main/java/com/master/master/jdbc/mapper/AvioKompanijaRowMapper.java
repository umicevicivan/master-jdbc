package com.master.master.jdbc.mapper;

import com.master.master.domain.AvioKompanija;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class AvioKompanijaRowMapper extends AbstractRowMapper<AvioKompanija> {
    @Override
    protected AvioKompanija mapRow() throws SQLException {
        AvioKompanija a = new AvioKompanija();
        a.setId(getInteger("id"));
        a.setNaziv(getString("naziv"));
        a.setCeo(getString("ceo"));
        a.setBrojDestinacija(getInteger("broj_destinacija"));
        a.setPozivniZnak(getString("pozivni_znak"));

        return a;
    }
}
