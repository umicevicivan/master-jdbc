package com.master.master.jdbc;

import com.master.master.domain.Avion;
import com.master.master.jdbc.mapper.AvionRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AvionDao extends AbstractDao {

    private final AvionRowMapper mapper;

    public AvionDao(AvionRowMapper mapper) {
        this.mapper = mapper;
    }

    public List<Avion> findAll() {
        String sql = "SELECT * FROM \"Avion\"";
        return jdbcTemplate.query(sql, mapper);
    }

    public List<Avion> findBoeing() {
        String sql = "SELECT * FROM \"Avion\" WHERE proizvodjac = 'Boeing'";
        return jdbcTemplate.query(sql, mapper);
    }

    public void deleteAll() {
        String sql = "DELETE FROM \"Avion\"";
        jdbcTemplate.update(sql);
    }

    public void insertAll() {
        Avion a = new Avion();
        String[] proizvodjac = {"Boeing", "Airbus", "Lockheed Martin", "Northrop Grumman", "Safran",
                "Rolls-Royce Holdings", "Bombardier"};
        int random;
        String sql = "INSERT INTO \"Avion\" VALUES(?, ?, ?, ?, ?)";
        for (int i = 1; i < 50500; i++){
            a.setId(i);
            a.setRegistracioniBroj((int) ((Math.random() * (999999 - 100000) + 100000)));
            random = (int) ((Math.random() * (7 - 0) + 0));
            a.setProizvodjac(proizvodjac[random]);
            a.setModel("MOD:" + a.getRegistracioniBroj().toString());
            a.setBrojSedista((int) ((Math.random() * (500 - 50) + 50)));
            jdbcTemplate.update(sql, a.getId(), a.getRegistracioniBroj(), a.getProizvodjac(), a.getModel(), a.getBrojSedista());
        }

    }
}
