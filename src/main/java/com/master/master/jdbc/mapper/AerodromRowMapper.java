package com.master.master.jdbc.mapper;

import com.master.master.domain.Aerodrom;
import com.master.master.domain.Drzava;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class AerodromRowMapper extends AbstractRowMapper<Aerodrom> {

    @Override
    protected Aerodrom mapRow() throws SQLException {
        Aerodrom a = new Aerodrom();
        a.setId(getInteger("id"));
        a.setNaziv(getString("naziv"));
        a.setBrojPista(getInteger("broj_pista"));
        a.setBrojPrilaza(getInteger("broj_prilaza"));
        a.setKapacitetAviona(getInteger("kapacitet_aviona"));

        Drzava d = new Drzava();
        d.setId(getInteger("id_drzave"));
        d.setNaziv(getString("naziv_drzave"));
        d.setSkraceniNaziv(getString("skraceni_naziv"));
        d.setBrojStanovnika(getInteger("broj_stanovnika"));

        a.setDrzava(d);

        return a;
    }
}
