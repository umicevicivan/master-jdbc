package com.master.master.jdbc.mapper;

import com.master.master.domain.Avion;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class PosedujeAvionRowMapper extends AbstractRowMapper<Avion> {

    @Override
    protected Avion mapRow() throws SQLException {
//        Poseduje p = new Poseduje();
//        AvioKompanija ak = new AvioKompanija();
//        ak.setId(getInteger("avio_kompanija_id"));
//        p.setDatumOd(getTimestamp("datum_od"));
//        p.setDatumDo(getTimestamp("datum_do"));

        Avion a = new Avion();
        a.setId(getInteger("id"));
        a.setRegistracioniBroj(getInteger("registracioni_broj"));
        a.setProizvodjac(getString("proizvodjac"));
        a.setModel(getString("model"));
        a.setBrojSedista(getInteger("broj_sedista"));

        return a;
    }
}
