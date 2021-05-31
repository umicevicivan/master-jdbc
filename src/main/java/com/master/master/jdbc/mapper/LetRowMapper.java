package com.master.master.jdbc.mapper;

import com.master.master.domain.Aerodrom;
import com.master.master.domain.Avion;
import com.master.master.domain.Let;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class LetRowMapper extends AbstractRowMapper<Let>{

    @Override
    protected Let mapRow() throws SQLException {
        Let l = new Let();
        l.setId(getInteger("id"));
        l.setPozivniZnak(getString("pozivni_znak"));
        l.setDatunPoletanja(getTimestamp("datum_poletanja"));
        l.setImePilota(getString("ime_pilota"));

        Avion a = new Avion();
        a.setId(getInteger("avion_id"));
        l.setAvion(a);

        Aerodrom aOd = new Aerodrom();
        aOd.setId(getInteger("aerodrom_od_id"));
        l.setAerodromOd(aOd);

        Aerodrom aDo = new Aerodrom();
        aOd.setId(getInteger("aerodrom_do_id"));
        l.setAerodromDo(aDo);

        return l;
    }
}
