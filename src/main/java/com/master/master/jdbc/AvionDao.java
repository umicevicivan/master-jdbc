package com.master.master.jdbc;

import com.master.master.domain.Avion;
import com.master.master.jdbc.mapper.AvionRowMapper;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AvionDao extends AbstractDao {

    private final AvionRowMapper mapper;

    public AvionDao(AvionRowMapper mapper) {
        this.mapper = mapper;
    }

    public List<Avion> findAll() {
        String sql = "SELECT * FROM IVAN.AVION";
        return jdbcTemplate.query(sql, mapper);
    }

    public void deleteAll() {
        String sql = "DELETE FROM IVAN.AVION";
        jdbcTemplate.update(sql);
    }

    public void updateRegBroj(int regBroj) {
        String sql = "UPDATE IVAN.AVION SET REGISTRACIONI_BROJ = ? WHERE 1=1";
        jdbcTemplate.update(sql, regBroj);
    }

    // ostale metode za izvrsavanje upita

    public List<Avion> findByProizvodjac(String proizvodjac) {
        String sql = "SELECT * FROM IVAN.AVION WHERE proizvodjac = ?";
        return jdbcTemplate.query(sql, mapper, proizvodjac);
    }

    public List<Avion> createList(int size) {
        List<Avion> avioni = new ArrayList<>();
        String[] proizvodjac = {"Boeing", "Airbus", "Lockheed Martin", "Northrop Grumman", "Safran",
                "Rolls-Royce Holdings", "Bombardier"};
        for (int i = 1; i <= size; i++) {
            Avion a = new Avion();
            a.setId(i);
            a.setRegistracioniBroj((int) ((Math.random() * (999999 - 100000) + 100000)));
            a.setProizvodjac(proizvodjac[(int) ((Math.random() * (7) + 0))]);
            a.setModel("MOD:" + a.getRegistracioniBroj().toString());
            a.setBrojSedista((int) ((Math.random() * (500 - 50) + 50)));
            avioni.add(a);
        }
        return avioni;
    }

    public void insertAll(List<Avion> avioni) {
        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(avioni.toArray());
        String sql = "INSERT INTO IVAN.AVION VALUES (:id, :registracioniBroj, :proizvodjac, :model, :brojSedista)";
        namedParameterJdbcTemplate.batchUpdate(sql, batch);
    }

//    public void insertAll(List<Avion> avioni) {
//        String sql = "INSERT INTO IVAN.AVION VALUES(?, ?, ?, ?, ?)";
//        avioni.forEach(a -> {
//            jdbcTemplate.update(sql, a.getId(), a.getRegistracioniBroj(),
//                    a.getProizvodjac(), a.getModel(), a.getBrojSedista());
//        });
//    }
}
