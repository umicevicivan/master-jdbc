package com.master.master.jdbc.mapper;

import com.master.master.domain.Avion;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class AvionRowMapper extends AbstractRowMapper<Avion>{

    @Override
    protected Avion mapRow() throws SQLException {
        Avion a = new Avion();
        a.setId(getInteger("id"));
        a.setRegistracioniBroj(getInteger("registracioni_broj"));
        a.setProizvodjac(getString("proizvodjac"));
        a.setModel(getString("model"));
        a.setBrojSedista(getInteger("broj_sedista"));

        return a;
    }
}
