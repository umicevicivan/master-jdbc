package com.master.master.jdbc;

import com.master.master.domain.Avion;
import com.master.master.jdbc.mapper.AvionRowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Avion1Dao extends AbstractDao {
    private final AvionRowMapper mapper;

    public static List<Avion> lista = new ArrayList<>();

    public Avion1Dao(AvionRowMapper mapper) {
        this.mapper = mapper;
    }

    public List<Avion> findAll() {
        String sql = "SELECT * FROM IVAN.AVION1";
        return jdbcTemplate.query(sql, mapper);
    }

    public List<Avion> findByProizvodjac(String proizvodjac) {
        String sql = "SELECT * FROM IVAN.AVION1 WHERE proizvodjac = ?";
        return jdbcTemplate.query(sql, mapper, proizvodjac);
    }

    public void deleteAll() {
        String sql = "DELETE FROM IVAN.AVION1";
        jdbcTemplate.update(sql);
    }

    public List<Avion> createList(int size) {
        String[] proizvodjac = {"Boeing", "Airbus", "Lockheed Martin", "Northrop Grumman", "Safran",
                "Rolls-Royce Holdings", "Bombardier"};
        for (int i = 1; i <= size; i++) {
            Avion a = new Avion();
            a.setId(i);
            a.setRegistracioniBroj((int) ((Math.random() * (999999 - 100000) + 100000)));
            a.setProizvodjac(proizvodjac[(int) ((Math.random() * (7) + 0))]);
            a.setModel("MOD:" + a.getRegistracioniBroj().toString());
            a.setBrojSedista((int) ((Math.random() * (500 - 50) + 50)));
            lista.add(a);
        }
        return lista;
    }

//    public void insertAll(List<Avion> avioni) {
//        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(avioni.toArray());
//        namedParameterJdbcTemplate.batchUpdate("INSERT INTO IVAN.AVION1 VALUES (:id, :registracioniBroj, :proizvodjac, :model, :brojSedista)", batch);
//
//    }

    public void insertAll(List<Avion> avioni) {
        String sql = "INSERT INTO IVAN.AVION1 VALUES(?, ?, ?, ?, ?)";
        lista.forEach(a -> jdbcTemplate.update(sql, a.getId(), a.getRegistracioniBroj(), a.getProizvodjac(), a.getModel(), a.getBrojSedista()));
    }

    public void update() {
        String sql = "UPDATE IVAN.AVION1 SET REGISTRACIONI_BROJ = 4343434 WHERE 1=1";
        jdbcTemplate.update(sql);
    }


}
