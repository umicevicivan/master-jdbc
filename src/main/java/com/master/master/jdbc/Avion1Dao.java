package com.master.master.jdbc;

import com.master.master.domain.Avion;
import com.master.master.jdbc.mapper.AvionRowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Avion1Dao extends AbstractDao{
    private final AvionRowMapper mapper;

    public static List<Avion> lista = new ArrayList<>();

    public Avion1Dao(AvionRowMapper mapper) {
        this.mapper = mapper;
    }

    public List<Avion> findAll() {
        String sql = "SELECT * FROM \"Avion1\"";
        return jdbcTemplate.query(sql, mapper);
    }

    public List<Avion> findBoeing() {
        String sql = "SELECT * FROM \"Avion1\" WHERE proizvodjac = 'Boeing'";
        return jdbcTemplate.query(sql, mapper);
    }

    public void deleteAll() {
        String sql = "DELETE FROM \"Avion1\"";
        jdbcTemplate.update(sql);
    }

    public List<Avion> createList() {
        String[] proizvodjac = {"Boeing", "Airbus", "Lockheed Martin", "Northrop Grumman", "Safran",
                "Rolls-Royce Holdings", "Bombardier"};
        for (int i = 1; i < 100; i++){
            Avion a = new Avion();
            a.setId(i);
            a.setRegistracioniBroj((int) ((Math.random() * (999999 - 100000) + 100000)));
            a.setProizvodjac(proizvodjac[(int) ((Math.random() * (7 - 0) + 0))]);
            a.setModel("MOD:" + a.getRegistracioniBroj().toString());
            a.setBrojSedista((int) ((Math.random() * (500 - 50) + 50)));
            lista.add(a);
        }
        return lista;
    }

    public void insertAll(){
        String sql = "INSERT INTO \"Avion1\" VALUES(?, ?, ?, ?, ?)";
        lista.forEach( a -> {
            jdbcTemplate.update(sql, a.getId(), a.getRegistracioniBroj(), a.getProizvodjac(), a.getModel(), a.getBrojSedista());
        });
    }

    public void update(){
        String sql = "UPDATE \"Avion1\" SET REGISTRACIONI_BROJ = 10 WHERE 1=1";
        jdbcTemplate.update(sql);
    }
}
