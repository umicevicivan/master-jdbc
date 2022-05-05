package com.master.master.jdbc;

import com.master.master.domain.Aerodrom;
import com.master.master.domain.Drzava;
import com.master.master.jdbc.mapper.AerodromRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AerodromDao extends AbstractDao {
    private final AerodromRowMapper mapper;

    public AerodromDao(AerodromRowMapper mapper) {
        this.mapper = mapper;
    }

    public List<Aerodrom> findAll() {
        String sql = "SELECT A.*, D.ID, D.SKRACENI_NAZIV, D.BROJ_STANOVNIKA, D.NAZIV as naziv_drzave FROM AERODROM A LEFT JOIN DRZAVA D on A.ID_DRZAVE = D.id";
        return jdbcTemplate.query(sql, mapper);
    }

    public List<Aerodrom> findByDrzava(String drzava) {
        String sql = "SELECT A.*, D.ID, D.SKRACENI_NAZIV, D.BROJ_STANOVNIKA, D.NAZIV as naziv_drzave " +
                "FROM IVAN.AERODROM A " +
                "LEFT JOIN IVAN.DRZAVA D on A.ID_DRZAVE = D.id " +
                "WHERE D.NAZIV LIKE ?";
        return jdbcTemplate.query(sql, mapper, drzava);
    }

    public void updateByNazivDrzave(String sufiks, String nazivDrzave) {
        String sql = "UPDATE IVAN.AERODROM a " +
                "set a.NAZIV = concat(a.NAZIV, ?) " +
                "WHERE a.ID_DRZAVE in ( Select d.ID from IVAN.DRZAVA d where d.NAZIV like ?)";
        jdbcTemplate.update(sql, sufiks, nazivDrzave);
    }

    public void deleteAll() {
        String sql = "DELETE FROM AERODROM";
        jdbcTemplate.update(sql);
    }

    public void insertAll() {
        Aerodrom a = new Aerodrom();

        String sql = "INSERT INTO AERODROM VALUES(?, ?, ?, ?, ?, ?)";
        for (int i = 1; i < 35000; i++) {
            a.setId(i);
            a.setNaziv("Naziv:" + i);
            int brojPista = (int) ((Math.random() * (3 - 1) + 1));
            a.setBrojPista(brojPista);
            a.setBrojPrilaza((int) ((Math.random() * (10 - brojPista) + brojPista)));
            a.setKapacitetAviona((int) ((Math.random() * (50 - 10) + 10)));
            Drzava d = new Drzava();
            d.setId((int) ((Math.random() * (242 - 1) + 1)));

            jdbcTemplate.update(sql, a.getId(), a.getNaziv(), a.getBrojPista(), a.getBrojPrilaza(), a.getKapacitetAviona(), a.getDrzava().getId());
        }

    }
}
