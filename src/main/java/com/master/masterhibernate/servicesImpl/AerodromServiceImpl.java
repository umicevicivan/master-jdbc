package com.master.masterhibernate.servicesImpl;

import com.master.masterhibernate.domain.Aerodrom;
import com.master.masterhibernate.repositories.AerodromRepository;
import com.master.masterhibernate.services.AerodromService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AerodromServiceImpl implements AerodromService {

    @Autowired
    private AerodromRepository aerodromRepository;

    @Override
    public List<Aerodrom> findAll() {
        return aerodromRepository.findAll();
    }

    @Override
    public List<Aerodrom> findAllByNazivDrzave(String naziv) {
        return aerodromRepository.findAllByDrzava_Naziv(naziv);
    }

    @Override
    @Transactional
    public List<Aerodrom> updateByNazivDrzave(String sufiks, String nazivDrzave) {
        List<Aerodrom> aerodromi = findAllByNazivDrzave(nazivDrzave);
        aerodromi.forEach(aerodrom -> aerodrom.setNaziv(aerodrom.getNaziv().concat(sufiks)));
        return aerodromRepository.saveAll(aerodromi);
    }

//    public List<Avion> createList() {
//        List<Avion> lista = new ArrayList<>();
//        String[] proizvodjac = {"Boeing", "Airbus", "Lockheed Martin", "Northrop Grumman", "Safran",
//                "Rolls-Royce Holdings", "Bombardier"};
//        for (int i = 1; i <= 100000; i++) {
//            Avion a = new Avion();
//            a.setId(i);
//            a.setRegistracioniBroj((int) ((Math.random() * (999999 - 100000) + 100000)));
//            a.setProizvodjac(proizvodjac[(int) ((Math.random() * (7 - 0) + 0))]);
//            a.setModel("MOD:" + a.getRegistracioniBroj());
//            a.setBrojSedista((int) ((Math.random() * (500 - 50) + 50)));
//            lista.add(a);
//        }
//        return lista;
//    }
}
