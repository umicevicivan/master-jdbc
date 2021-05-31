package com.master.master.jdbc;

import com.master.master.domain.Avion;
import com.master.master.domain.Osoba;
import com.master.master.jdbc.mapper.AvionRowMapper;
import com.master.master.jdbc.mapper.OsobaRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

@Repository
public class OsobaDao extends AbstractDao {
    private final OsobaRowMapper mapper;

    public OsobaDao(OsobaRowMapper mapper) {
        this.mapper = mapper;
    }

    public List<Osoba> findAll() {
        String sql = "SELECT * FROM \"Osoba\"";
        return jdbcTemplate.query(sql, mapper);
    }


    public void deleteAll() {
        String sql = "DELETE FROM \"Osoba\"";
        jdbcTemplate.update(sql);
    }

    public void insertAll() {
        Osoba o = new Osoba();

        String[] pol = {"muski", "zenski"};

        String sql = "INSERT INTO \"Osoba\" VALUES(?, ?, ?, ?, ?)";
        for (int i = 1; i < 40000; i++) {
            o.setId(i);
            o.setIme("Ime:" + i);
            o.setPrezime("Prezime:" + i);
            o.setGodine((int) ((Math.random() * (99 - 15) + 15)));
            o.setPol(pol[new Random().nextInt(pol.length)]);
            jdbcTemplate.update(sql, o.getId(), o.getIme(), o.getPrezime(), o.getGodine(), o.getPol());
        }

    }
}
