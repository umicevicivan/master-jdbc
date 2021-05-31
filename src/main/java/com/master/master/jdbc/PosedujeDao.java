package com.master.master.jdbc;

import com.master.master.domain.Avion;
import com.master.master.domain.Poseduje;
import com.master.master.jdbc.mapper.PosedujeAvionRowMapper;
import com.master.master.jdbc.mapper.PosedujeRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PosedujeDao extends AbstractDao {

    private final PosedujeRowMapper mapper;
    private final PosedujeAvionRowMapper mapper2;

    public PosedujeDao(PosedujeRowMapper mapper, PosedujeAvionRowMapper mapper2) {
        this.mapper = mapper;
        this.mapper2 = mapper2;
    }

    public List<Poseduje> findAll() {
        String sql = "SELECT * FROM \"Poseduje\"";
        return jdbcTemplate.query(sql, mapper);
    }

    public List<Avion> findAllPlanesForCompany(int companyId) {
        String sql = "SELECT * FROM \"Poseduje\" P JOIN \"Avion\" A ON P.AVION_ID = A.ID WHERE P.AVIO_KOMPANIJA_ID = ?";
        return jdbcTemplate.query(sql, mapper2, companyId);
    }

    public void deleteAll() {
        String sql = "DELETE FROM \"Poseduje\"";
        jdbcTemplate.update(sql);
    }

    public void insertAll() {
        String sql = "INSERT INTO \"Poseduje\" VALUES(?, ?, ?, ?)";

        for (int i = 1; i < 60000; i++) {
//            Poseduje p = new Poseduje();
//            p.setIdAvion((int) ((Math.random() * (50499 - 1) + 1)));
//            p.setIdAvioKompanija((int) ((Math.random() * (53 - 1) + 1)));
//            p.setDatumOd(new Timestamp(new Date().getTime()));
//            p.setDatumDo(new Timestamp(new Date().getTime()));
//            jdbcTemplate.update(sql, p.getIdAvioKompanija(), p.getIdAvion(), p.getDatumOd(), p.getDatumDo());
        }
    }
}
