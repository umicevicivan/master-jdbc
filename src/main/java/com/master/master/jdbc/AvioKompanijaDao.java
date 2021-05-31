package com.master.master.jdbc;

import com.master.master.domain.AvioKompanija;
import com.master.master.jdbc.mapper.AvioKompanijaRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AvioKompanijaDao extends AbstractDao {

    @Autowired
    public static PosedujeDao posedujeDao;

    private final AvioKompanijaRowMapper mapper;

    public AvioKompanijaDao(AvioKompanijaRowMapper mapper, PosedujeDao posedujeDao) {
        this.mapper = mapper;
        this.posedujeDao = posedujeDao;
    }

    public List<AvioKompanija> findAll() {
        List<AvioKompanija> avioKompanije =  findAvioKompanije();
        avioKompanije.forEach(avioKompanija -> {
            avioKompanija.setAvioni(posedujeDao.findAllPlanesForCompany(avioKompanija.getId()));
        });
        return avioKompanije;

    }

    private List<AvioKompanija> findAvioKompanije(){
        String sql = "SELECT * FROM \"AvioKompanija\"";
        return jdbcTemplate.query(sql, mapper);
    }

    public void deleteAll() {
        String sql = "DELETE FROM \"AvioKompanija\"";
        jdbcTemplate.update(sql);
    }

    public void update(String newName, String oldName) {
            String sql = "UPDATE \"AvioKompanija\" SET ceo = ? WHERE CEO like ?";
            jdbcTemplate.update(sql, newName, oldName);
    }


    public void insertAll() {
        AvioKompanija a = new AvioKompanija();
        String[] naziv = {"Aegean Airlines",
                "Aer Lingus",
                "Aeroflot",
                "Aerolineas Argentinas",
                "Aeromexico",
                "Air Arabia",
                "Air Astana",
                "Air Austral",
                "Air Baltic",
                "Air Belgium",
                "Air Canada",
                "Air Caraibes",
                "Air China",
                "Air Corsica",
                "Air Dolomiti",
                "Air Europa",
                "Air France",
                "Air India",
                "Air India Express",
                "Air Macau",
                "Air Malta",
                "Air Mauritius",
                "Air Namibia",
                "Air New Zealand",
                "Air North",
                "Air Seoul",
                "Air Serbia",
                "Air Tahiti Nui",
                "Air Transat",
                "Air Vanuatu",
                "AirAsia",
                "AirAsia X",
                "Aircalin",
                "Alaska Airlines",
                "Alitalia",
                "Allegiant",
                "American Airlines",
                "ANA",
                "Asiana",
                "Austrian",
                "Avianca",
                "Azerbaijan Hava Yollary",
                "Azores Airlines",
                "Azul", "easyJet",
                "Edelweiss Air",
                "Egyptair",
                "EL AL",
                "Emirates",
                "Ethiopian Airlines",
                "Etihad",
                "Eurowings",
                "EVA Air"
        };
        String sql = "INSERT INTO \"AvioKompanija\" VALUES(?, ?, ?, ?, ?)";
        for (int i = 1; i < 53; i++) {
            a.setId(i);
            a.setNaziv(naziv[i - 1]);
            a.setCeo("ceo");
            a.setBrojDestinacija((int) ((Math.random() * (150 - 2) + 2)));
            a.setPozivniZnak("PZ:" + i);
            jdbcTemplate.update(sql, a.getId(), a.getNaziv(), a.getCeo(), a.getBrojDestinacija(), a.getPozivniZnak());
        }



    }
}
