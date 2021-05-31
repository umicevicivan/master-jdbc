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
        String sql = "SELECT A.*, D.ID, D.SKRACENI_NAZIV, D.BROJ_STANOVNIKA, D.NAZIV as naziv_drzave FROM \"Aerodrom\" A LEFT JOIN \"Drzava\" D on A.ID_DRZAVE = D.id";
        return jdbcTemplate.query(sql, mapper);
    }

    public List<Aerodrom> searchCountry(String country) {
        String sql = "SELECT A.*, D.ID, D.SKRACENI_NAZIV, D.BROJ_STANOVNIKA, D.NAZIV as naziv_drzave " +
                "FROM \"Aerodrom\" A " +
                "LEFT JOIN \"Drzava\" D on A.ID_DRZAVE = D.id " +
                "WHERE d.NAZIV LIKE ?";
        return jdbcTemplate.query(sql, mapper, country);
    }

    public void updateName(String newName, String countryName){
        String sql = "UPDATE \"Aerodrom\"" +
                "set NAZIV = concat(NAZIV, ?)\n" +
                "WHERE ID_DRZAVE in ( Select ID from \"Drzava\" where \"Drzava\".NAZIV like ?)";
        jdbcTemplate.update(sql, newName, countryName);
    }

    public void deleteAll() {
        String sql = "DELETE FROM \"Aerodrom\"";
        jdbcTemplate.update(sql);
    }

    public void insertAll() {
        Aerodrom a = new Aerodrom();

        String sql = "INSERT INTO \"Aerodrom\" VALUES(?, ?, ?, ?, ?, ?)";
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
