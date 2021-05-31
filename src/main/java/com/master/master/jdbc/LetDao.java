package com.master.master.jdbc;

import com.master.master.domain.Aerodrom;
import com.master.master.domain.Avion;
import com.master.master.domain.Let;
import com.master.master.jdbc.mapper.LetRowMapper;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public class LetDao extends AbstractDao {

    private final LetRowMapper mapper;

    public LetDao(LetRowMapper mapper) {
        this.mapper = mapper;
    }

    public List<Let> findAll() {
        String sql = "SELECT * FROM \"Let\"";
        return jdbcTemplate.query(sql, mapper);
    }

    public void deleteAll() {
        String sql = "DELETE FROM \"Let\"";
        jdbcTemplate.update(sql);
    }

    public void insert() {
        String sql = "INSERT INTO \"Let\" VALUES(?, ?, ?, ?, ?, ?, ?)";
        Let l = new Let();
        int id = 11;
        l.setId(id);
        l.setPozivniZnak("PZ: " + id);
        l.setDatunPoletanja(new Timestamp(new Date().getTime()));
        l.setImePilota("Ime pilota: " + id);
        Avion a = new Avion();
        a.setId((int) ((Math.random() * (50499 - 1) + 1)));
        l.setAvion(a);
        Aerodrom aOd = new Aerodrom();
        aOd.setId((int) ((Math.random() * (35000 - 1) + 1)));
        l.setAerodromOd(aOd);
        Aerodrom aDo = new Aerodrom();
        aDo.setId((int) ((Math.random() * (35000 - 1) + 1)));
        if (aOd.getId() == aDo.getId()) {
            System.out.println("Ima taj id vec");
            return;
        }
        l.setAerodromDo(aDo);
        jdbcTemplate.update(sql, l.getId(), l.getPozivniZnak(), l.getDatunPoletanja(), l.getImePilota(),
                l.getAvion().getId(), l.getAerodromOd().getId(), l.getAerodromDo().getId());

    }
}
