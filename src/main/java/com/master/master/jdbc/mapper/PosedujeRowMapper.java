package com.master.master.jdbc.mapper;

import com.master.master.domain.AvioKompanija;
import com.master.master.domain.Avion;
import com.master.master.domain.Poseduje;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class PosedujeRowMapper extends AbstractRowMapper<Poseduje> {

    @Override
    protected Poseduje mapRow() throws SQLException {
        Poseduje p = new Poseduje();

        AvioKompanija ak = new AvioKompanija();
        ak.setId(getInteger("avio_kompanija_id"));

        Avion a = new Avion();
        a.setId(getInteger("avion_id"));

        p.setAvioKompanija(ak);
        p.setAvion(a);
        p.setDatumOd(getTimestamp("datum_od"));
        p.setDatumDo(getTimestamp("datum_do"));
        return p;
    }
}
