package com.master.master.jdbc;

import com.master.master.domain.AvioKompanija;
import com.master.master.domain.Avion;
import com.master.master.jdbc.mapper.AvioKompanijaRowMapper;
import com.master.master.jdbc.mapper.AvionRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AvioKompanijaDao extends AbstractDao {

    @Autowired
    private final AvioKompanijaRowMapper mapper;
    @Autowired
    private final AvionRowMapper avionRowMapper;

    public AvioKompanijaDao(AvioKompanijaRowMapper mapper, AvionRowMapper avionRowMapper) {
        this.mapper = mapper;
        this.avionRowMapper = avionRowMapper;
    }

    public List<AvioKompanija> findAll() {
        List<AvioKompanija> avioKompanije = findAvioKompanije();
        avioKompanije.forEach(avioKompanija ->
                avioKompanija.setAvioni(findAvioniForAvioKompanija(avioKompanija.getId())));
        return avioKompanije;
    }

    private List<AvioKompanija> findAvioKompanije() {
        String sql = "SELECT * FROM IVAN.AVIO_KOMPANIJA";
        return jdbcTemplate.query(sql, mapper);
    }

    private List<Avion> findAvioniForAvioKompanija(int avioKompanijaId) {
        String sql = "select p.avio_kompanija_id as avio_kompanija_id, " +
                "p.avion_id as avion_id, " +
                "av.id as id, " +
                "av.broj_sedista as broj_sedista, " +
                "av.model as model, " +
                "av.proizvodjac as proizvodjac, " +
                "av.registracioni_broj as registracioni_broj " +
                "from ivan.poseduje p " +
                "inner join ivan.avion av on p.avion_id = av.id " +
                "where p.avio_kompanija_id = ?";
        return jdbcTemplate.query(sql, avionRowMapper, avioKompanijaId);
    }

    public void deleteAll() {
        String sql = "DELETE FROM IVAN.AVIO_KOMPANIJA";
        jdbcTemplate.update(sql);
    }

    public void update(String newName, String oldName) {
        String sql = "UPDATE IVAN.AVIO_KOMPANIJA SET ceo = ? WHERE CEO like ?";
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
        String sql = "INSERT INTO IVAN.AVIO_KOMPANIJA VALUES(?, ?, ?, ?, ?)";
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
